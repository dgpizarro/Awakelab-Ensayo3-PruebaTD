package cl.awakelab.ensayo3.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.awakelab.ensayo3.model.Curso;

public class CursoDAO {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public class CursoMapper implements RowMapper<Curso> {
        public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
            Curso c = new Curso();
            c.setIdcurso(rs.getInt(1));
            c.setNombre(rs.getString(2));
            c.setN_alumnos(rs.getInt(3));
            return c;
        }
    }

    public List<Curso> listarCursos() {
        String sql = "select c.idcurso, c.nombre, count(idalumno) from curso c left join alumno a"
                + " on (c.idcurso = a.idcurso) group by c.idcurso, c.nombre order by 1";
        return template.query(sql, new CursoMapper());
    }

}

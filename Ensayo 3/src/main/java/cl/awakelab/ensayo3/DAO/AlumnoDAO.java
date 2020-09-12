package cl.awakelab.ensayo3.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.awakelab.ensayo3.model.Alumno;

public class AlumnoDAO {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public class AlumnoMapper implements RowMapper<Alumno> {
        public Alumno mapRow(ResultSet rs, int rowNum) throws SQLException {
            Alumno a = new Alumno();
            a.setIdalumno(rs.getInt(1));
            a.setNombre(rs.getString(2));
            return a;
        }
    }

    public List<Alumno> listarAlumnosCurso(int idcurso) {
        String sql = "select idalumno, a.nombre from alumno a inner join curso c on "
                + "(c.idcurso = a.idcurso) where a.idcurso = " + idcurso + " order by 2";
        return template.query(sql, new AlumnoMapper());
    }

}

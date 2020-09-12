package cl.awakelab.ensayo3.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import cl.awakelab.ensayo3.DAO.AlumnoDAO;
import cl.awakelab.ensayo3.DAO.CursoDAO;
import cl.awakelab.ensayo3.model.Alumno;
import cl.awakelab.ensayo3.model.Curso;

@Controller
public class PrincipalController {

    static Logger log = Logger.getLogger(PrincipalController.class);

    @Autowired
    AlumnoDAO ad;

    @Autowired
    CursoDAO cd;
    
    public List<Alumno> obtenerAlumnos(int idcurso, int port){
        String uri = "http://localhost:"+ port +"/ensayo3/api/lalumnos/" + idcurso;
        
        RestTemplate restTemplate = new RestTemplate();
        
        ResponseEntity<Alumno[]> respuesta = restTemplate.getForEntity(uri, Alumno[].class);
                    
        return Arrays.asList(respuesta.getBody());
    }

    @RequestMapping({ "/index", "/" })
    public String irPortal(Model m) {
        
        try {
            
            List<Curso> lcursos = cd.listarCursos();
            m.addAttribute("cursos", lcursos);
            log.log(Level.INFO, "Búsqueda de cursos disponibles en base datos -> SQL");
            
        } catch (Exception e) {
            
            log.log(Level.ERROR, e);
        }
        
        log.log(Level.INFO, "Ingreso a index");
        return "ListaCursos";
    }

    @RequestMapping("/detalleAlumnos/{idcurso}")
    public String detallarAlumnos(@PathVariable int idcurso, Model m, HttpServletRequest r) {
        int port = r.getServerPort();
        
        try {
            
            m.addAttribute("alumnos", obtenerAlumnos(idcurso, port));
            
            log.log(Level.INFO, "Ingreso a modal deatlle alumnos por curso ID: " + idcurso);
            
        } catch (Exception e) {
            
            log.log(Level.ERROR, e);
        } 
        
        return "DetalleAlumnos";
    }

}

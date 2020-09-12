package cl.awakelab.ensayo3.controller;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cl.awakelab.ensayo3.DAO.AlumnoDAO;
import cl.awakelab.ensayo3.model.Alumno;

@RestController
@RequestMapping(path = "/api", headers = "Accept=application/json" )
public class ApiController {
    
    @Autowired
    AlumnoDAO ad;
    
    static Logger log = Logger.getLogger(ApiController.class);
    
    @GetMapping(path = "/lalumnos/{idcurso}")
    public List<Alumno> getAlumnos (@PathVariable int idcurso) {
        
        try {
            List<Alumno> lista_al = ad.listarAlumnosCurso(idcurso);
            log.log(Level.INFO, "Búsqueda de alumnos de curso " + idcurso + " -> SQL");
            return lista_al;
        } catch (Exception e) {
            log.log(Level.ERROR, e);
            return null;
        }
        
           
    }
    
    

}

package cl.awakelab.ensayo3.test;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class PrincipalControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
        
    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
    @Test
    public void testIrPortal() throws Exception {
        
        this.mvc
                .perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("ListaCursos"))
                .andExpect(model().attributeExists("cursos"))
                .andExpect(model().attribute("cursos", isA(Iterable.class)))
                .andExpect(model().attribute("cursos",
                                hasItem(allOf(hasProperty("idcurso", is(1)),
                                hasProperty("nombre", is("Primero básico")),
                                hasProperty("n_alumnos", is(4))))))
                .andDo(print());
    }

    
      
    @Test
    public void testDetallarAlumnos() throws Exception {      
        
        this.mvc.
                perform(get("/detalleAlumnos/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("DetalleAlumnos"))
                .andDo(print());
      
    }

}

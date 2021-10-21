package pe.com.iv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.com.iv.domain.Persona;

@Controller
@Slf4j
public class Controlador {

    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String Inicio(Model model) {
        String mensaje = "Mensaje con thymeleaf";

        Persona persona = new Persona();
        persona.setNombre("Isaac");
        persona.setApellido("Vilchez C");
        persona.setEmail("i@vilchez.com");
        persona.setTelefono("921883655");

        Persona persona2 = new Persona();
        persona2.setNombre("Karla");
        persona2.setApellido("Gomez");
        persona2.setEmail("Karl@vilchez.com");
        persona2.setTelefono("998556841");

        Persona persona3 = new Persona();
        persona3.setNombre("Juan");
        persona3.setApellido("Perez");
        persona3.setEmail("JPerez@vilchez.com");
        persona3.setTelefono("985563589");

        //List<Persona> personas = new ArrayLit();
        //var personas = Arrays.asList(persona, persona2);
        List<Persona> personas = new ArrayList();
        personas.add(persona);
        personas.add(persona2);
        personas.add(persona3);
        //personas.add(persona2);

        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        //model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        return "index";
    }

}

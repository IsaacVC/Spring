package pe.com.iv.web;

import java.util.List;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.iv.domain.Persona;
import pe.com.iv.servicio.PersonaService;

@Controller
@Slf4j
public class Controlador {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String Inicio(Model model) {

        List<Persona> personas = personaService.listaPersona();
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";git
    }
}

package pe.com.iv.web;

import java.util.List;
import javax.validation.Valid;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }        
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
            
}

package pe.com.iv.web;

import java.util.ArrayList;
import java.util.Arrays;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.com.iv.dao.PersonaDao;
import pe.com.iv.domain.Persona;

@Controller
@Slf4j
public class Controlador {

    @Autowired
    private PersonaDao personaDao;

    @GetMapping("/")
    public String Inicio(Model model) {

        var personas = personaDao.findAll();
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        return "index";
    }

}

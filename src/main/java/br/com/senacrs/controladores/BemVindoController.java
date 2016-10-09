package br.com.senacrs.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(value = "bem-vindo")
public class BemVindoController {

    public BemVindoController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public String loginForm(Model model, @RequestParam Optional<String> error) {
        model.addAttribute("error", error);
        return "bem-vindo";
    }
    
}

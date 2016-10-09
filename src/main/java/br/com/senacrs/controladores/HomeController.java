package br.com.senacrs.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String loginForm(HttpServletRequest request) {
        if(request.getUserPrincipal() == null) {
            return "redirect:/bem-vindo";
        } else {
            return "redirect:/login";
        }
    }
}

package br.com.senacrs.controladores;

import br.com.senacrs.entidades.Doenca;
import br.com.senacrs.repositorios.DoencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "doencas")
public class DoencaController {
    private DoencaRepository doencaRepository;

    @Autowired
    public DoencaController(DoencaRepository doencaRepository) {
        this.doencaRepository = doencaRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listDoencas(Model model) {
        List<Doenca> doencas = doencaRepository.findAll();
        model.addAttribute("doencas", doencas);

        return "doencas/lista";
    }

    @RequestMapping(value = "criar", method = RequestMethod.GET)
    public String novoDoencaForm() {
        return "doencas/formulario-novo";
    }

    @RequestMapping(value = "criar", method = RequestMethod.POST)
    public String novoDoenca(HttpServletRequest request) {
        Doenca doenca = this.createOrUpdateEntityFromRequest(null, request);
        return "redirect:/doencas/editar/" + doenca.getId();
    }

    @RequestMapping(value = "editar/{id}", method = RequestMethod.GET)
    public String editDoencaForm(Model model, @PathVariable("id") Integer id) {
        Doenca doenca = this.doencaRepository.findOne(id);
        model.addAttribute("doencas", doenca);
        return "doencas/formulario-editar";
    }

    @RequestMapping(value = "editar/{id}", method = RequestMethod.POST)
    public String editDoenca(@PathVariable("id") Integer id, HttpServletRequest request) {
        Doenca doenca = this.doencaRepository.findOne(id);

        this.createOrUpdateEntityFromRequest(doenca, request);
        return "redirect:/doencas/editar/" + doenca.getId();
    }

    @RequestMapping(value = "remover/{id}", method = RequestMethod.GET)
    public String removerDoenca(@PathVariable("id") Integer id) {
        this.doencaRepository.delete(id);
        return "redirect:/doencas";
    }

    private Doenca createOrUpdateEntityFromRequest(Doenca doenca, HttpServletRequest request) {
        if(doenca == null)
            doenca = new Doenca();
        
        doenca.setCid(request.getParameter("cid"));
        doenca.setNome(request.getParameter("nome"));
        doenca.setSintoma(request.getParameter("sintoma"));
        doenca.setCausa(request.getParameter("causa"));
        doenca.setTratamento(request.getParameter("tratamento"));
        doenca.setPatologia(request.getParameter("patologia"));
        
        return this.doencaRepository.save(doenca);
    }
}

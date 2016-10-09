package br.com.senacrs.controladores;

import br.com.senacrs.entidades.Atendimento;
import br.com.senacrs.entidades.TipoSanguineo;
import br.com.senacrs.entidades.TipoSexo;
import br.com.senacrs.entidades.Usuario;
import br.com.senacrs.repositorios.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@Controller
@RequestMapping(value = "atendimentos")
public class AtendimentoController {
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    public AtendimentoController(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listAtendimentos(Model model) {
        model.addAttribute("atendimentos", atendimentoRepository.findAll());
        return "atendimentos/lista";
    }

    @RequestMapping(value = "visualizar/{id}", method = RequestMethod.GET)
    public String verAtendimento(Model model, @PathVariable("id") Integer id) {
        Atendimento atendimento = this.atendimentoRepository.findOne(id);
        model.addAttribute("atendimento", atendimento);
        return "atendimentos/visualizar";
    }

    @RequestMapping(value = "criar", method = RequestMethod.GET)
    public String novoAtendimentoForm() {
        return "atendimentos/formulario-novo";
    }

    @RequestMapping(value = "criar", method = RequestMethod.POST)
    public String novoAtendimento(HttpServletRequest request) {
        Atendimento atendimento = this.createOrUpdateEntityFromRequest(null, request);
        return "redirect:/atendimentos/editar/" + atendimento.getId();
    }

    @RequestMapping(value = "editar/{id}", method = RequestMethod.GET)
    public String editAtendimentoForm(Model model, @PathVariable("id") Integer id) {
        Atendimento atendimento = this.atendimentoRepository.findOne(id);
        model.addAttribute("atendimento", atendimento);
        return "atendimentos/formulario-editar";
    }

    @RequestMapping(value = "editar/{id}", method = RequestMethod.POST)
    public String editAtendimento(@PathVariable("id") Integer id, HttpServletRequest request) {
        Atendimento atendimento = this.atendimentoRepository.findOne(id);

        this.createOrUpdateEntityFromRequest(atendimento, request);
        return "redirect:/atendimentos/editar/" + atendimento.getId();
    }

    @RequestMapping(value = "remover/{id}", method = RequestMethod.GET)
    public String removerAtendimento(@PathVariable("id") Integer id) {
        this.atendimentoRepository.delete(id);
        return "redirect:/atendimentos";
    }

    private Atendimento createOrUpdateEntityFromRequest(Atendimento atendimento, HttpServletRequest request) {
        if(atendimento == null)
            atendimento = new Atendimento();

        //atendimento.setDataInicio(request.getParameter("dataInicio"));
        atendimento.setTitulo(request.getParameter("titulo"));
        atendimento.setDescricao(request.getParameter("descricao"));

        return this.atendimentoRepository.save(atendimento);
    }
}

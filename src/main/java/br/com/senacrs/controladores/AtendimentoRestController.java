package br.com.senacrs.controladores;

import br.com.senacrs.entidades.Atendimento;
import br.com.senacrs.repositorios.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/atendimentos")
public class AtendimentoRestController {

    private AtendimentoRepository atendimentoRepository;

    @Autowired
    public AtendimentoRestController(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Atendimento> listAtendimentos() {
        return atendimentoRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createAtendimento(@RequestBody Atendimento addAtendimentoRequest) {
        atendimentoRepository.save(addAtendimentoRequest);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Atendimento getAtendimento(@PathVariable("id") Integer id) {
        return atendimentoRepository.findOne(id);
    }
}
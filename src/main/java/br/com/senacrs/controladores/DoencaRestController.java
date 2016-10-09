package br.com.senacrs.controladores;

import br.com.senacrs.entidades.Doenca;
import br.com.senacrs.repositorios.DoencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/doencas")
public class DoencaRestController {

    private DoencaRepository doencaRepository;

    @Autowired
    public DoencaRestController(DoencaRepository doencaRepository) {
        this.doencaRepository = doencaRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Doenca> listDoencas() {
        return doencaRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createDoenca(@RequestBody Doenca addDoencaRequest) {
        doencaRepository.save(addDoencaRequest);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Doenca getDoenca(@PathVariable("id") Integer id) {
        return doencaRepository.findOne(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Doenca editDoenca(@PathVariable("id") Integer id, Doenca newData) {
        Doenca oldDoenca = doencaRepository.findOne(id);
        newData.setId(oldDoenca.getId());

        return doencaRepository.save(newData);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public boolean deleteDoenca(@PathVariable("id") Integer id) {
        doencaRepository.delete(id);

        return true;
    }
}
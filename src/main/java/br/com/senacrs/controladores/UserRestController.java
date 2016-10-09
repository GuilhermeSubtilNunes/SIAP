package br.com.senacrs.controladores;

import br.com.senacrs.entidades.Usuario;
import br.com.senacrs.repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/usuarios")
public class UserRestController {

    private UserRepository userRepository;

    @Autowired
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Usuario> listUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createUser(@RequestBody Usuario addUserRequest) {
        userRepository.save(addUserRequest);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Usuario getUser(@PathVariable("id") Integer id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Usuario editUser(@PathVariable("id") Integer id, Usuario newData) {
        Usuario oldUser = userRepository.findOne(id);
        newData.setId(oldUser.getId());

        return userRepository.save(newData);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable("id") Integer id) {
        userRepository.delete(id);

        return true;
    }
}
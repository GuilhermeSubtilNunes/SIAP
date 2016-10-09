package br.com.senacrs.controladores;

import br.com.senacrs.entidades.Role;
import br.com.senacrs.entidades.TipoSanguineo;
import br.com.senacrs.entidades.TipoSexo;
import br.com.senacrs.entidades.Usuario;
import br.com.senacrs.repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "usuarios")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listUsuarios(Model model) {
        List<Usuario> usuarios = userRepository.findAll();
        model.addAttribute("usuarios", usuarios);

        return "usuarios/lista";
    }

    @RequestMapping(value = "criar", method = RequestMethod.GET)
    public String novoUsuarioForm() {
        return "usuarios/formulario-novo";
    }

    @RequestMapping(value = "criar", method = RequestMethod.POST)
    public String novoUsuario(HttpServletRequest request) {
        Usuario usuario = this.createOrUpdateEntityFromRequest(null, request);
        return "redirect:/usuarios/editar/" + usuario.getId();
    }

    @RequestMapping(value = "editar/{id}", method = RequestMethod.GET)
    public String editUsuarioForm(Model model, @PathVariable("id") Integer id) {
        Usuario usuario = this.userRepository.findOne(id);
        model.addAttribute("usuario", usuario);
        return "usuarios/formulario-editar";
    }

    @RequestMapping(value = "editar/{id}", method = RequestMethod.POST)
    public String editUsuario(@PathVariable("id") Integer id, HttpServletRequest request) {
        Usuario usuario = this.userRepository.findOne(id);

        this.createOrUpdateEntityFromRequest(usuario, request);
        return "redirect:/usuarios/editar/" + usuario.getId();
    }

    @RequestMapping(value = "remover/{id}", method = RequestMethod.GET)
    public String removerUsuario(@PathVariable("id") Integer id) {
        this.userRepository.delete(id);
        return "redirect:/usuarios";
    }

    private Usuario createOrUpdateEntityFromRequest(Usuario usuario, HttpServletRequest request) {
        if(usuario == null)
            usuario = new Usuario();

        usuario.setLogin(request.getParameter("login"));
        usuario.setSenha(request.getParameter("senha"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setNome(request.getParameter("nome"));
        usuario.setSexo(TipoSexo.valueOf(request.getParameter("sexo")));
        usuario.setTipoSanguineo(TipoSanguineo.valueOf(request.getParameter("tipoSanguineo")));
        usuario.setTelefone(request.getParameter("telefone"));
        usuario.setCidade(request.getParameter("cidade"));
        usuario.setEstado(request.getParameter("estado"));
        usuario.setCep(request.getParameter("cep"));
        usuario.setObservacoes(request.getParameter("observacoes"));
        usuario.setRole(Role.valueOf(request.getParameter("role")));

        return this.userRepository.save(usuario);
    }
}

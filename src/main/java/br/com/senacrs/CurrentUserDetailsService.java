package br.com.senacrs;

import br.com.senacrs.entidades.Usuario;
import br.com.senacrs.repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

    private final UserRepository userService;

    @Autowired
    public CurrentUserDetailsService(UserRepository userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario user = userService.findByLogin(login);
        if(user == null)
            throw new UsernameNotFoundException(String.format("User with login=%s was not found", login));

        return new CurrentUser(user);
    }

}

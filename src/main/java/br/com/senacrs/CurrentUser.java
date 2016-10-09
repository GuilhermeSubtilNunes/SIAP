package br.com.senacrs;

import br.com.senacrs.entidades.Role;
import br.com.senacrs.entidades.Usuario;
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private Usuario user;

    public CurrentUser(Usuario user) {
        super(user.getEmail(), user.getSenha(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public Usuario getUser() {
        return user;
    }

    public Long getId() {
        return (long) user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }

}
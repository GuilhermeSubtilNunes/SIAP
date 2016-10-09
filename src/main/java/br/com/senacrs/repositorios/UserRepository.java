package br.com.senacrs.repositorios;

import br.com.senacrs.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByLogin(String login);
}

package br.com.senacrs.repositorios;

import br.com.senacrs.entidades.Doenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoencaRepository extends JpaRepository<Doenca, Integer> {
    
}

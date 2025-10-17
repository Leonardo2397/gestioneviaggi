package leonardoferrante.gestioneviaggi.repositories;

import leonardoferrante.gestioneviaggi.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {

    Optional<Dipendente> findByUsername(String username);

    Optional<Dipendente> findByEmail(String email);

}

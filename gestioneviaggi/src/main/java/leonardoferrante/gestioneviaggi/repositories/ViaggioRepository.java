package leonardoferrante.gestioneviaggi.repositories;

import leonardoferrante.gestioneviaggi.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {

    List<Viaggio> findByDate(LocalDate date);

    List<Viaggio> findByStato(String stato);
}

package leonardoferrante.gestioneviaggi.repositories;

import leonardoferrante.gestioneviaggi.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public interface ViaggioRepository extends JpaRepository {

    List<Viaggio> findByDate(LocalDate date);

    List<Viaggio> findByState(String state);
}

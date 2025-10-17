package leonardoferrante.gestioneviaggi.repositories;

import leonardoferrante.gestioneviaggi.entities.Dipendente;
import leonardoferrante.gestioneviaggi.entities.Prenotazione;
import leonardoferrante.gestioneviaggi.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PrenotazioneRepository extends JpaRepository <Prenotazione, Long> {

    // controlla se un dipendente ha gia una prenotazione in data x
    Optional<Prenotazione> findByDipendenteAndViaggio_Date(Dipendente dipendente, LocalDate date);

    //controlal tutte le prenotazioni di un dipendente
    List<Prenotazione> findByDipendente(Dipendente dipendente);

    //controlla tutte le prenotazioni di un viaggio
    List<Prenotazione> findByViaggio(Viaggio viaggio);
}

package leonardoferrante.gestioneviaggi.services;

import leonardoferrante.gestioneviaggi.entities.Dipendente;
import leonardoferrante.gestioneviaggi.entities.Prenotazione;
import leonardoferrante.gestioneviaggi.entities.Viaggio;
import leonardoferrante.gestioneviaggi.exceptions.NotFoundExceptions;
import leonardoferrante.gestioneviaggi.payload.NewPrenotazionePayload;
import leonardoferrante.gestioneviaggi.repositories.DipendenteRepository;
import leonardoferrante.gestioneviaggi.repositories.PrenotazioneRepository;
import leonardoferrante.gestioneviaggi.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private ViaggioRepository viaggioRepository;

    public List<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();
    }

    public Prenotazione savePrenotazione(NewPrenotazionePayload payload) {
        Dipendente dipendente = dipendenteRepository.findById(payload.getDipendenteId())
                .orElseThrow(() -> new NotFoundExceptions("Dipendente", payload.getDipendenteId()));
        Viaggio viaggio = viaggioRepository.findById(payload.getViaggioId())
                .orElseThrow(() -> new NotFoundExceptions("Viaggio", payload.getViaggioId()));

        // controllo per prenotazione doppia nello stesso giorno
        prenotazioneRepository.findByDipendenteAndViaggio_Date(dipendente, viaggio.getDate())
                .ifPresent(p-> { throw new RuntimeException("dipendente gia prenotato in questa data");});

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        prenotazione.setRequestData(java.time.LocalDate.now());
        prenotazione.setNote(payload.getNote());
        prenotazione.setPreferences(payload.getPreferences());

        return prenotazioneRepository.save(prenotazione);
    }

    public Prenotazione findById(Long id) {
        return prenotazioneRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptions("Prenotazione", id));
    }

    public void findByIdAndDelete(Long id) {
        Prenotazione prenotazione = findById(id);
        prenotazioneRepository.delete(prenotazione);
    }

    public List<Prenotazione> findByDipendenteId(Long dipendenteid) {
        Dipendente dipendente = dipendenteRepository.findById(dipendenteid)
                .orElseThrow(() -> new NotFoundExceptions("Dipendente", dipendenteid));
        return prenotazioneRepository.findByDipendente(dipendente);
    }

    public List<Prenotazione> findBYViaggioId(Long viaggioId) {
        Viaggio viaggio = viaggioRepository.findById(viaggioId)
                .orElseThrow(() -> new NotFoundExceptions("Viaggio", viaggioId));
        return prenotazioneRepository.findByViaggio(viaggio);
    }
}

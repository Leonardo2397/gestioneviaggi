package leonardoferrante.gestioneviaggi.services;

import leonardoferrante.gestioneviaggi.entities.StatoViaggio;
import leonardoferrante.gestioneviaggi.entities.Viaggio;
import leonardoferrante.gestioneviaggi.exceptions.NotFoundExceptions;
import leonardoferrante.gestioneviaggi.payload.NewViaggioPayload;
import leonardoferrante.gestioneviaggi.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

    public List<Viaggio> findAll() {
        return viaggioRepository.findAll();
    }

    public Viaggio saveViaggio(NewViaggioPayload payload) {
        Viaggio viaggio = new Viaggio();
        viaggio.setDestination(payload.getDestination());
        viaggio.setDate(payload.getDate());
        viaggio.setStato(payload.getStato() != null ? StatoViaggio.valueOf(payload.getStato()) : StatoViaggio.IN_PROGRAMMA);
        return viaggioRepository.save(viaggio);
    }

    public Viaggio findById(Long id) {
        return viaggioRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptions("Viaggio", id));
    }

    public Viaggio findByIdAndUpdate(Long id, NewViaggioPayload payload) {
        Viaggio existing = findById(id);
        existing.setDestination(payload.getDestination());
        existing.setDate(payload.getDate());
        if(payload.getStato() != null) {
            existing.setStato(StatoViaggio.valueOf(payload.getStato()));
        }
        return viaggioRepository.save(existing);
    }

    public void findByIdAndDelete(Long id) {
        Viaggio existing = findById(id);
        viaggioRepository.delete(existing);
    }

    public Viaggio changeStato(Long id) {
        Viaggio viaggio = findById(id);
        viaggio.setStato(viaggio.getStato() == StatoViaggio.IN_PROGRAMMA ? StatoViaggio.COMPLETATO : StatoViaggio.IN_PROGRAMMA);
        return viaggioRepository.save(viaggio);
    }
}

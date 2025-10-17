package leonardoferrante.gestioneviaggi.services;


import leonardoferrante.gestioneviaggi.entities.Dipendente;
import leonardoferrante.gestioneviaggi.exceptions.NotFoundExceptions;
import leonardoferrante.gestioneviaggi.payload.NewDipendentePayload;
import leonardoferrante.gestioneviaggi.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public List<Dipendente> findAll() {
        return dipendenteRepository.findAll();
    }

    public Dipendente saveDipendente(NewDipendentePayload payload) {
        //controla se username e email sono unici
        dipendenteRepository.findByUsername(payload.getUsername())
                .ifPresent(d ->{ throw new RuntimeException("username gia esistente"); });
        dipendenteRepository.findByEmail(payload.getEmail())
                .ifPresent(d ->{ throw new RuntimeException("email gia esistente"); });

        Dipendente dipendente = new Dipendente();
        dipendente.setUsername(payload.getUsername());
        dipendente.setName(payload.getName());
        dipendente.setSurname(payload.getSurname());
        dipendente.setEmail(payload.getEmail());
       // dipendente.setProfileImageUrl("https://ui-avatars.com/api/?name=" + payload.getName() + "&background=random&color=fff");

        return dipendenteRepository.save(dipendente);
    }

    public Dipendente findById(Long id) {
        return dipendenteRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptions("Dipendente", id));
    }

    public Dipendente findByIdAndUpdate(Long id, NewDipendentePayload payload) {
        Dipendente existing = findById(id);
        existing.setUsername(payload.getUsername());
        existing.setName(payload.getName());
        existing.setSurname(payload.getSurname());
        existing.setEmail(payload.getEmail());
        return dipendenteRepository.save(existing);
    }

    public void findByIdAndDelete(Long id) {
        Dipendente existing = findById(id);
        dipendenteRepository.delete(existing);
    }
}

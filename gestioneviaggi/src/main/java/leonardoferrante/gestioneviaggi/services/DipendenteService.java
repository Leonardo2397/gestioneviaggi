package leonardoferrante.gestioneviaggi.services;


import leonardoferrante.gestioneviaggi.entities.Dipendente;
import leonardoferrante.gestioneviaggi.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public List<Dipendente> findAll
}

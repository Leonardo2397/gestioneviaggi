package leonardoferrante.gestioneviaggi.controller;


import jakarta.validation.Valid;
import leonardoferrante.gestioneviaggi.entities.Prenotazione;
import leonardoferrante.gestioneviaggi.payload.NewPrenotazionePayload;
import leonardoferrante.gestioneviaggi.payload.NewViaggioPayload;
import leonardoferrante.gestioneviaggi.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping
    public List<Prenotazione> getAll() {
        return prenotazioneService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazione create(@RequestBody @Valid NewPrenotazionePayload payload) {
        return prenotazioneService.savePrenotazione(payload);
    }

    @GetMapping("/{id}")
    public Prenotazione getById(@PathVariable Long id) {
        return prenotazioneService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        prenotazioneService.findByIdAndDelete(id);
    }

    @GetMapping("/dipendente/{dipendenteId}")
    public List<Prenotazione> getBydipendente(@PathVariable Long dipendenteId) {
        return prenotazioneService.findByDipendenteId(dipendenteId);
    }

    @GetMapping("/viaggio/{viaggioId}")
    public List<Prenotazione> getByViaggio(@PathVariable Long viaggioId) {
        return prenotazioneService.findBYViaggioId(viaggioId);
    }
}

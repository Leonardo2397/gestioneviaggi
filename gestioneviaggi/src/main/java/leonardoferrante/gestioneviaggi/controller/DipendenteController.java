package leonardoferrante.gestioneviaggi.controller;


import jakarta.validation.Valid;
import leonardoferrante.gestioneviaggi.entities.Dipendente;
import leonardoferrante.gestioneviaggi.payload.NewDipendentePayload;
import leonardoferrante.gestioneviaggi.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping
    public List<Dipendente> getAll() {
        return dipendenteService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente create(@RequestBody @Valid NewDipendentePayload payload) {
        return dipendenteService.saveDipendente(payload);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getById(@PathVariable Long id) {
        return ResponseEntity.ok(dipendenteService.findById(id));
    }

    @PutMapping("/{id}")
    public Dipendente update(@PathVariable Long id, @RequestBody @Valid NewDipendentePayload payload) {
        return dipendenteService.findByIdAndUpdate(id, payload);
    }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void delete(@PathVariable Long id) {
            dipendenteService.findByIdAndDelete(id);
        }
    }




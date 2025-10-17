package leonardoferrante.gestioneviaggi.controller;


import jakarta.validation.Valid;
import leonardoferrante.gestioneviaggi.entities.Viaggio;
import leonardoferrante.gestioneviaggi.payload.NewViaggioPayload;
import leonardoferrante.gestioneviaggi.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    @GetMapping
    public List<Viaggio> getAll() {
        return viaggioService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Viaggio create(@RequestBody @Valid NewViaggioPayload payload) {
        return viaggioService.saveViaggio(payload);
    }

    @GetMapping("/{id}")
    public Viaggio getById(@PathVariable Long id) {
        return viaggioService.findById(id);
    }

    @PutMapping("/{id}")
    public Viaggio update(@PathVariable Long id, @RequestBody @Valid NewViaggioPayload payload) {
        return viaggioService.findByIdAndUpdate(id, payload);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        viaggioService.findByIdAndDelete(id);
    }

    @PatchMapping("/{id}/stato")
    public Viaggio changeStato(@PathVariable Long id) {
        return viaggioService.changeStato(id);
    }


}

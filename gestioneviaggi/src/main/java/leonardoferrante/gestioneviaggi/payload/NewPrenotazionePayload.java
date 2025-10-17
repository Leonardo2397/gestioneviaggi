package leonardoferrante.gestioneviaggi.payload;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NewPrenotazionePayload {

    @NotNull
    private Long dipendenteId;

    @NotNull
    private Long viaggioId;

    private String note;

    private String preferences;



}

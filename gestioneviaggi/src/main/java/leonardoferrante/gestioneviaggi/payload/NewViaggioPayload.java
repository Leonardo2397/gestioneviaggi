package leonardoferrante.gestioneviaggi.payload;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class NewViaggioPayload {

    @NotBlank
    private String destination;

    @Future//per data futura
    private LocalDate date;

    private String stato;
}

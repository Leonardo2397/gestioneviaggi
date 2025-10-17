package leonardoferrante.gestioneviaggi.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class NewViaggioPayload {

    @NotBlank
    private String destination;

    @Future//per data futura
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String stato;
}

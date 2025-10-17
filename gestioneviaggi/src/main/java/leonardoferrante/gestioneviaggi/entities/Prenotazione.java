package leonardoferrante.gestioneviaggi.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Dipendente dipendente;

    @ManyToOne(optional = false)
    private Viaggio viaggio;

    @Column(nullable = false)
    private LocalDate requestData;

    private String note;

    private String preferences;
}

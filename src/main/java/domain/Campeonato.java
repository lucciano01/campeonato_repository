package domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "campeonatos.findAll", query = "select c from Campeonato c"),
        @NamedQuery(name = "campeonato.byName", query = "select c from Campeonato c where c.nomeCampeonato = :nome")
})
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    private String nomeCampeonato;

    private LocalDate dataInicio;

    private LocalDate dataFim;

}

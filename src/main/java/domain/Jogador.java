package domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@DiscriminatorValue("J")
@NamedQueries({
        @NamedQuery(name = "jogador.findAll", query = "select j from Jogador j")
})
public class Jogador extends Profissional {

    private String posicao;
    private boolean isTitular;

    @ManyToOne
    private Equipe equipe;
}

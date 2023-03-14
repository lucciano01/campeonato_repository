package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@DiscriminatorValue("T")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "tecnico.findAll", query = "select t from Tecnico t")
})
public class Tecnico extends Profissional {

   private String matriculaCBF;

}

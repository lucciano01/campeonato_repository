package dao;

import domain.Jogador;

import javax.persistence.Query;
import java.util.List;

public class JogadorDAO extends ProfissionalDAO{

    public void saveOrUpdate(Jogador jogador) {
        super.saveOrUpdate(jogador);
    }

    public Jogador findById(Class clazz, Long id) {
        return (Jogador)super.findById(clazz, id);
    }

    public void remove(Jogador jogador) {
        remove(jogador);
    }

    public List<Jogador> findAll(){
        Query query = getJpaPersistence().getEm()
                .createNamedQuery("jogador.findAll");
        return query.getResultList();
    }


}

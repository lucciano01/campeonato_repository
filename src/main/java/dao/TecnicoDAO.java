package dao;

import domain.Tecnico;

import javax.persistence.Query;
import java.util.List;

public class TecnicoDAO extends ProfissionalDAO {

    public void saveOrUpdate(Tecnico tecnico) {
        super.saveOrUpdate(tecnico);
    }

    public Tecnico findById(Class clazz, Long id) {
        return (Tecnico) super.findById(clazz, id);
    }

    public void remove(Tecnico tecnico) {
        remove(tecnico);
    }

    public List<Tecnico> findAll(){
        Query query = getJpaPersistence().getEm()
                .createNamedQuery("tecnico.findAll");
        return query.getResultList();
    }
}

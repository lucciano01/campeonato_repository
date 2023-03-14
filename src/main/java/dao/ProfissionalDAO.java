package dao;

import domain.Profissional;
import persistence.JpaPersistence;

public class ProfissionalDAO implements GenericDAO<Profissional>{

    private JpaPersistence jpaPersistence;

    public ProfissionalDAO(){
        this.jpaPersistence = new JpaPersistence();
    }

    @Override
    public void saveOrUpdate(Profissional object) {
        this.jpaPersistence.getEm().getTransaction().begin();
        this.jpaPersistence.getEm().merge(object);
        this.jpaPersistence.getEm().getTransaction().commit();
    }

    @Override
    public Profissional findById(Class clazz, Long id) {
        return (Profissional) this.jpaPersistence.getEm().find(clazz, id);
    }

    @Override
    public void remove(Profissional object) {
        this.jpaPersistence.getEm().remove(object);
        this.jpaPersistence.getEm().getTransaction().commit();
    }

    public JpaPersistence getJpaPersistence() {
        return jpaPersistence;
    }
}

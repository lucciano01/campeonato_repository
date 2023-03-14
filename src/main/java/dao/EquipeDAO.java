package dao;

import domain.Equipe;
import persistence.JpaPersistence;


public class EquipeDAO implements GenericDAO<Equipe>{

    private JpaPersistence jpaPersistence;
    
    public EquipeDAO(){
       this.jpaPersistence = new JpaPersistence();
    }
    

    @Override
    public void saveOrUpdate(Equipe equipe) {
        jpaPersistence.getEm().getTransaction().begin();
        jpaPersistence.getEm().merge(equipe);
        jpaPersistence.getEm().getTransaction().commit();
    }

    @Override
    public Equipe findById(Class clazz, Long id) {
        return (Equipe) jpaPersistence.getEm().find(clazz, id);
    }

    @Override
    public void remove(Equipe object) {
        jpaPersistence.getEm().remove(object);
    }
}

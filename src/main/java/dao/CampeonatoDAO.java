package dao;

import domain.Campeonato;
import persistence.JpaPersistence;

import javax.persistence.Query;
import java.util.List;

public class CampeonatoDAO implements GenericDAO<Campeonato>{

    private JpaPersistence jpaPersistence;

    public CampeonatoDAO(){
        this.jpaPersistence = new JpaPersistence();
    }

    @Override
    public void saveOrUpdate(Campeonato campeonato) {
        this.jpaPersistence.getEm().getTransaction().begin();
        this.jpaPersistence.getEm().persist(campeonato);
        this.jpaPersistence.getEm().getTransaction().commit();
    }

    @Override
    public Campeonato findById(Class clazz, Long id) {
        return (Campeonato) jpaPersistence.getEm().find(clazz, id);
    }

    @Override
    public void remove(Campeonato campeonato) {
        jpaPersistence.getEm().remove(campeonato);
        jpaPersistence.getEm().getTransaction().commit();
    }

    public List<Campeonato> findALL(){
        Query query = jpaPersistence.getEm()
                .createNamedQuery("campeonatos.findAll");
        return query.getResultList();
    }

    public Campeonato campeonatoByName(String nome){
        Query query = jpaPersistence.getEm().createNamedQuery("campeonato.byName");
        query.setParameter("nome", nome);
        return (Campeonato) query.getSingleResult();
    }

}

package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Objects;

public class JpaPersistence {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("campeonato_pu");

    private EntityManager em;

    public EntityManager getEm() {
       if(Objects.isNull(em)){
           em = emf.createEntityManager();
       }
        return em;
    }
}

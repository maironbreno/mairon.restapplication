package br.mairon.restapplication.Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by mairon.nunes on 16/08/2017.
 */
public class PersistenceHelper {

    protected EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bd_livraria");

    public EntityManager obterEntityManager() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}

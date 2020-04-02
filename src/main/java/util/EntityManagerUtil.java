package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    private static EntityManagerFactory factory;

    private EntityManagerUtil(){};

    public static EntityManager getEntityManager(){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory("koval");
        }
        return factory.createEntityManager();
    }
}

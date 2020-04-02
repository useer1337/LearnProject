package GW;

import Exceptions.EntityNotFound;
import util.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class SimpleGW<T> implements GW<T> {
    private EntityManager em = EntityManagerUtil.getEntityManager();
    private Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public SimpleGW(){
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")
    public List<T> all() {
        return em.createQuery("select t from" + persistentClass.getSimpleName() + "t").getResultList();
    }

    public T find(Long id) throws EntityNotFound {
        T person = em.find(persistentClass, id);
        if (person == null)
            throw new EntityNotFound(String.format("Entity with id=%d not found", id ));
        return person;
    }

    public void insert(T object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    public void update(T object) throws EntityNotFound {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();

    }

    public void delete(T object) {
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
    }
}

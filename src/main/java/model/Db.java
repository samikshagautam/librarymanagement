package model;

import org.bson.types.ObjectId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class Db<T> {
    protected static EntityManager manager;

    public Db() {
        getManager();
    }

    public static EntityManager getManager() {
        if (manager != null) {
            return manager;
        }
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ogm-mongodb");
        manager = factory.createEntityManager();
        return manager;
    }

    public Optional<T> insert(T obj) {
        try {
            EntityManager manager = getManager();
            manager.getTransaction().begin();
            manager.persist(obj);
            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Exception");
            System.out.println(e.getMessage());
        }
        return Optional.of(obj);
    }

    public T update(T obj, ObjectId id) {
        try {
            EntityManager manager = getManager();
            manager.getTransaction().begin();
            Object d = manager.find(obj.getClass(), id);
            manager.merge(obj);
            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Exception");
            System.out.println(e.getMessage());
        }
        return obj;
    }

    public T findOne(Class<T> cls, ObjectId id) {
        try {
            EntityManager manager = getManager();
            manager.getTransaction().begin();
            T obj = manager.find(cls, id);
            manager.getTransaction().commit();
            return obj;
        } catch (Exception e) {
            System.out.println("Exception");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<T> find(Class<T> tClass, String collection) {
        try {
            EntityManager manager = getManager();
            manager.getTransaction().begin();
            List<T> results = manager.createQuery("from " + collection, tClass).getResultList();
            manager.getTransaction().commit();
            return results;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public T delete(T obj, ObjectId id) {
        try {
            EntityManager manager = getManager();
            manager.getTransaction().begin();
            Object object = manager.find(obj.getClass(), id);
            manager.remove(object);
            manager.getTransaction().commit();
            return obj;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}

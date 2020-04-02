package GW;

import Exceptions.EntityNotFound;

import java.util.List;

public interface GW<T> {
    List<T> all();
    T find(Long id) throws EntityNotFound;
    void insert(T object);
    void update(T object) throws EntityNotFound;
    void delete(T object);
}

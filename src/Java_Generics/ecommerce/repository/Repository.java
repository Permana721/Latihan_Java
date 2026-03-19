package Java_Generics.ecommerce.repository;

import java.util.List;

public interface Repository<T> {
    void save(T item);
    void delete(int id);
    T findById(int id);
    List<T> findAll();
}

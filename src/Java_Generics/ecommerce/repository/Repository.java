package Java_Generics.ecommerce.repository;

import Java_Generics.ecommerce.domain.product.Product;
import Java_Generics.ecommerce.exception.ProductNotFoundException;

import java.util.List;

public interface Repository<T> {
    void save(T item);
    void delete(int id) throws ProductNotFoundException;
    Product findByName(String name) throws ProductNotFoundException;
    List<T> findAll();
}
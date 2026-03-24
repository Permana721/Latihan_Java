package Java_Generics.ecommerce.service;

import Java_Generics.ecommerce.domain.product.Category;
import Java_Generics.ecommerce.domain.product.Product;

import java.util.List;

public interface ProductService {
    void addProduct(String name, int price, int stock, Category category);
    List<Product> getAllProduct();
}

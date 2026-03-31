package Java_Generics.ecommerce.repository;

import Java_Generics.ecommerce.domain.product.Product;
import Java_Generics.ecommerce.domain.user.User;
import Java_Generics.ecommerce.exception.InvalidUserException;
import Java_Generics.ecommerce.exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements Repository<Product> {
    private ArrayList<Product> allProduct = new ArrayList<>();
    private int nextId = 1;


    @Override
    public void save(Product item) {
        item.setId(nextId++);
        allProduct.add(item);
    }

    @Override
    public void delete(int id) throws ProductNotFoundException {
        allProduct.removeIf(p -> p.getId() == id);
        throw new ProductNotFoundException(id);
    }

    public Product findProductByName(String name) throws ProductNotFoundException {
        for (Product p : allProduct) {
            if (p.getName().equalsIgnoreCase(name)) return p;
        }
        throw new ProductNotFoundException(name);
    }

    @Override
    public List<Product> findAll() {
        return allProduct;
    }
}

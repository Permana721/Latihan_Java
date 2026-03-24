package Java_Generics.ecommerce.repository;

import Java_Generics.ecommerce.domain.product.Product;
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

    @Override
    public Product findByName(String name) throws ProductNotFoundException {
        for (Product product : allProduct) {
            if(product.getName().equalsIgnoreCase(name)){
                product.printInfo();
                return product;
            }
        }
        throw new ProductNotFoundException(name);
    }

    @Override
    public List<Product> findAll() {
        return allProduct;
    }
}

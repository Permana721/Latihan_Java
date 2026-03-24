package Java_Generics.ecommerce.repository;

import Java_Generics.ecommerce.domain.product.Product;
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
    public void delete(int id) {
        allProduct.removeIf(p -> p.getId() == id);
    }

    @Override
    public Product findById(int id) {
        for (Product p : allProduct) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return allProduct;
    }
}

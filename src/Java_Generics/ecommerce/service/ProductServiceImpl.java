package Java_Generics.ecommerce.service;

import Java_Generics.ecommerce.domain.product.Category;
import Java_Generics.ecommerce.domain.product.Product;
import Java_Generics.ecommerce.exception.InvalidUserException;
import Java_Generics.ecommerce.repository.ProductRepository;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepo;
    private int nextId = 1;

    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public void addProduct(String name, int price, int stock, Category category) {
        if (name == null || name.isEmpty()) {
            throw new InvalidUserException("Nama tidak boleh kosong");
        }

        for (Product p : productRepo.findAll()) {
            if (p.getName().equals(name)) {
                throw new InvalidUserException("Username '" + name + "' sudah dipakai");
            }
        }

        Product product = new Product(nextId++, name, price, stock, category);
        productRepo.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }
}

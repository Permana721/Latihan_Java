package Java_Generics.ecommerce.service;

import Java_Generics.ecommerce.domain.product.Category;
import Java_Generics.ecommerce.domain.product.Product;
import Java_Generics.ecommerce.domain.user.User;
import Java_Generics.ecommerce.exception.InvalidUserException;
import Java_Generics.ecommerce.exception.OutOfStockException;
import Java_Generics.ecommerce.exception.ProductNotFoundException;
import Java_Generics.ecommerce.repository.ProductRepository;
import Java_Generics.ecommerce.repository.UserRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepo;
    private UserRepository userRepo;
    private int nextId = 1;

    public ProductServiceImpl(ProductRepository productRepo, UserRepository userRepo) {
        this.productRepo = productRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void addProduct(String name, int price, int stock, Category category) {
        if (name == null || name.isEmpty()) {
            throw new InvalidUserException("Nama tidak boleh kosong");
        }

        for (Product product : productRepo.findAll()) {
            if (product.getName().equals(name)) {
                throw new InvalidUserException("Username '" + name + "' sudah dipakai");
            }
        }

        Product product = new Product(nextId++, name, price, stock, category);
        productRepo.save(product);
    }

    public void buyProduct(int userId, String name)
        throws ProductNotFoundException, InvalidUserException, OutOfStockException {

        if (name == null || name.isEmpty()) {
            throw new InvalidUserException("Nama produk tidak boleh kosong");
        }

        User user       = userRepo.findUserById(userId);
        Product product = productRepo.findProductByName(name);

        if (product.getStock() <= 0) {
            throw new OutOfStockException(product.getName());
        }

        if (user.getSaldo() < product.getPrice()) {
            throw new InvalidUserException(
                    "Saldo tidak cukup. Saldo kamu: Rp" + user.getSaldo() +
                            ", Harga produk: Rp" + product.getPrice()
            );
        }

        user.setSaldo(user.getSaldo() - product.getPrice());
        product.setStock(product.getStock() - 1);

        System.out.println("✓ Pembelian berhasil!");
        product.printInfo();
        System.out.println("  Sisa saldo kamu: Rp" + user.getSaldo());
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }
}

package Java_Generics.ecommerce.exception;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(int id) {
        super("Produk dengan id " + id + " tidak ditemukan\n");
    }

    public ProductNotFoundException(String name) {
        super("Produk dengan nama " + name + " tidak ditemukan\n");
    }
}

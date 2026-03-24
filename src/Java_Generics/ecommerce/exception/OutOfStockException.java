package Java_Generics.ecommerce.exception;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(int id) {
        super("Stok produk dengan id " + id + " sudah habis!\n");
    }

    public OutOfStockException(String name) {
        super("Stok produk dengan nama " + name + " sudah habis!\n");
    }
}

package Java_Generics.ecommerce;

import Java_Generics.ecommerce.domain.product.Category;
import Java_Generics.ecommerce.domain.product.Product;

public class Main {
    static void main(String[] args) {
        Product p1 = new Product("Laptop", 10_000_000, Category.ELECTRONICS);
        Product p2 = new Product("Nasi Goreng", 20000, Category.FOOD);

        p1.printInfo();
        p2.printInfo();
    }
}

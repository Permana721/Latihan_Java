package Java_Generics.ecommerce;

import Java_Generics.ecommerce.domain.product.Category;
import Java_Generics.ecommerce.domain.product.Product;
import Java_Generics.ecommerce.domain.user.User;
import Java_Generics.ecommerce.repository.ProductRepository;
import Java_Generics.ecommerce.repository.UserRepository;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        boolean jalan = true;
        Scanner input = new Scanner(System.in);

        ProductRepository productRepo = new ProductRepository();
        productRepo.save(new Product(1, "Laptop Axioo", 9_000_000, Category.ELECTRONICS));
        productRepo.save(new Product(2, "Mouse NYK", 200_000, Category.ELECTRONICS));
        productRepo.save(new Product(3, "Baju Polos", 50_000, Category.FASHION));
        productRepo.save(new Product(4, "Mie Ayam", 30_000, Category.FOOD));

        UserRepository userRepository = new UserRepository();
        userRepository.save(new User(1, "Permana", 5_000_000));

        while (jalan){
            for (User i : userRepository.findAll()){
                if(i != null){
                    i.printInfo();
                }
            }
            System.out.println("Selamat Datang di E-Commerce! Silahkan Pilih menu");
            System.out.println("1. Tampilkan semua produk \n2. Cari produk \n3. Beli Produk \n0. Keluar");
            System.out.print("Pilih: ");
            int pilihan = input.nextInt();
            input.nextLine();
            System.out.println("\n");

            switch (pilihan){
                case 1 -> {
                    for (Product i : productRepo.findAll()){
                        if(i != null){
                            i.printInfo();
                        }
                    }
                }
                case 0 -> {
                    jalan = false;
                    System.out.println("Silahkan datang kembali!");
                }
            }
        }


    }
}

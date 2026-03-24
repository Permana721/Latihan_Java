package Java_Generics.ecommerce;

import Java_Generics.ecommerce.domain.product.Category;
import Java_Generics.ecommerce.domain.product.Product;
import Java_Generics.ecommerce.domain.user.User;
import Java_Generics.ecommerce.exception.InvalidUserException;
import Java_Generics.ecommerce.exception.ProductNotFoundException;
import Java_Generics.ecommerce.repository.ProductRepository;
import Java_Generics.ecommerce.repository.UserRepository;
import Java_Generics.ecommerce.service.ProductService;
import Java_Generics.ecommerce.service.ProductServiceImpl;
import Java_Generics.ecommerce.service.UserService;
import Java_Generics.ecommerce.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    static void main(String[] args) throws ProductNotFoundException {
        boolean jalan = true;
        Scanner input = new Scanner(System.in);

        ProductRepository productRepo = new ProductRepository();
        ProductService productService = new ProductServiceImpl(productRepo);
        try {
            productService.addProduct("Laptop Axioo", 9_000_000, 10, Category.ELECTRONICS);
            productService.addProduct("Mouse NYK", 200_000, 20, Category.ELECTRONICS);
            productService.addProduct("Baju Polos", 50_000, 30,  Category.FASHION);
            productService.addProduct("Mie Ayam", 30_000, 50, Category.FOOD);
        } catch (InvalidUserException e) {
            System.out.println("Error: " + e.getMessage());
        }

        UserRepository  userRepo    = new UserRepository();
        UserService userService = new UserServiceImpl(userRepo);
        try {
            userService.register("Arido", "arido@email.com");
        } catch (InvalidUserException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        while (jalan){
            for (User i : userRepo.findAll()){
                if(i != null){
                    i.printInfo();
                }
            }
            System.out.println("Selamat Datang di E-Commerce! Silahkan Pilih menu");
            System.out.println("1. Tampilkan semua produk \n2. Cari produk \n3. Beli Produk \n0. Keluar");
            System.out.print("Pilih: ");
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan){
                case 1 -> {
                    for (Product i : productRepo.findAll()){
                        if(i != null){
                            i.printInfo();
                        }
                    }
                }
                case 2 -> {
                    System.out.print("Masukan nama Produk yang ingin anda cari: ");
                    String nama = input.nextLine();
                    try {
                        productRepo.findByName(nama);
                    } catch (ProductNotFoundException e) {
                        System.out.println("\nERROR: " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.print("Masukan nama Produk yang ingin anda beli: ");
                    String nama = input.nextLine();
                    productRepo.findByName(nama);
                }
                case 0 -> {
                    jalan = false;
                    System.out.println("Silahkan datang kembali!");
                }
            }
        }
    }
}

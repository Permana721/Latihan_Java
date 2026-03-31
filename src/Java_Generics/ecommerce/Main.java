package Java_Generics.ecommerce;

import Java_Generics.ecommerce.domain.product.Category;
import Java_Generics.ecommerce.domain.product.Product;
import Java_Generics.ecommerce.domain.user.User;
import Java_Generics.ecommerce.exception.InvalidUserException;
import Java_Generics.ecommerce.exception.OutOfStockException;
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
        User currentUser = null;
        ProductRepository productRepo = new ProductRepository();
        UserRepository    userRepo    = new UserRepository();
        ProductService productService = new ProductServiceImpl(productRepo, userRepo);
        try {
            productService.addProduct("Laptop Axioo", 9_000_000, 10, Category.ELECTRONICS);
            productService.addProduct("Mouse NYK", 200_000, 20, Category.ELECTRONICS);
            productService.addProduct("Baju Polos", 50_000, 30,  Category.FASHION);
            productService.addProduct("Mie Ayam", 30_000, 50, Category.FOOD);
        } catch (InvalidUserException e) {
            System.out.println("Error: " + e.getMessage());
        }

        UserService userService = new UserServiceImpl(userRepo);
        try {
            userService.register("Arido", "arido@email.com");
        } catch (InvalidUserException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        while (jalan){
            if (currentUser == null) {
                System.out.println("\n╔══════════════════════════════╗");
                System.out.println("║   Selamat Datang di Toko!   ║");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("║  1. Lihat semua produk      ║");
                System.out.println("║  2. Cari produk             ║");
                System.out.println("║  ─────────────────────────  ║");
                System.out.println("║  3. Register                ║");
                System.out.println("║  4. Login                   ║");
                System.out.println("║  ─────────────────────────  ║");
                System.out.println("║  0. Keluar                  ║");
                System.out.println("╚══════════════════════════════╝");

            } else {
                System.out.println("\n╔══════════════════════════════╗");
                System.out.println("║  Halo, " + currentUser.getName() + "!");
                System.out.println("║  Saldo: Rp" + currentUser.getSaldo());
                System.out.println("╠══════════════════════════════╣");
                System.out.println("║  1. Lihat semua produk      ║");
                System.out.println("║  2. Cari produk             ║");
                System.out.println("║  3. Beli produk             ║");
                System.out.println("║  ─────────────────────────  ║");
                System.out.println("║  4. Isi saldo               ║");
                System.out.println("║  5. Logout                  ║");
                System.out.println("║  ─────────────────────────  ║");
                System.out.println("║  0. Keluar                  ║");
                System.out.println("╚══════════════════════════════╝");
            }

            System.out.print("Pilih: ");
            int pilihan = input.nextInt();
            input.nextLine();

            if (currentUser == null) {
                switch (pilihan) {
                    case 1 -> {
                        System.out.println("\n=== Semua Produk ===");
                        for (Product product : productRepo.findAll()) {
                            product.printInfo();
                        }
                    }
                    case 2 -> {
                        System.out.print("Nama produk: ");
                        String name = input.nextLine();
                        try {
                            productRepo.findProductByName(name).printInfo();
                        } catch (ProductNotFoundException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                    }
                    case 3 -> {
                        System.out.print("Username : ");
                        String username = input.nextLine();
                        System.out.print("Email    : ");
                        String email = input.nextLine();
                        try {
                            userService.register(username, email);
                        } catch (InvalidUserException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                    }
                    case 4 -> {
                        System.out.print("Username : ");
                        String username = input.nextLine();
                        System.out.print("Email    : ");
                        String email = input.nextLine();
                        try {
                            currentUser = userService.login(username, email);
                        } catch (InvalidUserException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                    }
                    case 0 -> {
                        System.out.println("Sampai jumpa!");
                        jalan = false;
                    }
                    default -> System.out.println("Pilihan tidak tersedia");
                }
            } else {
                switch (pilihan) {
                    case 1 -> {
                        System.out.println("\n=== Semua Produk ===");
                        for (Product product : productRepo.findAll()) {
                            product.printInfo();
                        }
                    }
                    case 2 -> {
                        System.out.print("Nama produk: ");
                        String name = input.nextLine();
                        try {
                            productRepo.findProductByName(name).printInfo();
                        } catch (ProductNotFoundException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                    }
                    case 3 -> {
                        System.out.print("Nama produk yang ingin dibeli: ");
                        String name = input.nextLine();
                        try {
                            productService.buyProduct(currentUser.getId(), name);
                        } catch (ProductNotFoundException | OutOfStockException | InvalidUserException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                    }
                    case 4 -> {
                        System.out.print("Jumlah saldo yang ingin ditambah: Rp");
                        int jumlah = input.nextInt();
                        try {
                            userService.tambahSaldo(currentUser.getId(), jumlah);
                        } catch (InvalidUserException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                    }
                    case 5 -> {
                        System.out.println("Logout berhasil. Sampai jumpa, " + currentUser.getName() + "!");
                        currentUser = null;
                    }
                    case 0 -> {
                        System.out.println("Sampai jumpa!");
                        jalan = false;
                    }
                    default -> System.out.println("Pilihan tidak tersedia");
                }
            }
        }
    }
}

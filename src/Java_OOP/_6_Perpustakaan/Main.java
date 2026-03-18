package Java_OOP._6_Perpustakaan;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static void main(String[] args) {
        boolean jalan = true;
        Library library = new Library();
        ArrayList<Book> semuaBuku = library.addBook();
        User user = new User("Permana");
        Scanner input = new Scanner(System.in);

        while (jalan){
            System.out.println("Nama: " + user.getName());
            System.out.println("Menu: \n1. Lihat buku \n2. Pinjam buku \n3. Cari buku \n4. Koleksi \n5. Kembalikan buku \n0. Keluar");
            System.out.print("Pilih: ");
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan){
                case 1 -> {
                    System.out.println("========== DAFTAR BUKU ==========");
                    for (Book books : semuaBuku) {
                        books.tampilBuku();
                        System.out.println("---------------------------------------");
                    }
                } case 2 -> {
                    System.out.println("Masukkan ID Buku yang ingin anda pinjam: ");
                    int id = input.nextInt();
                    library.borrowBook(library.semuaBuku, id);
                } case 3 -> {
                    System.out.println("Masukan nama buku yang ingin anda cari: ");
                    String nama = input.nextLine();
                    library.searchBook(nama);
                } case 4 -> {
                    library.getCollectionBook();
                } case 5 -> {
                    System.out.println("Masukkan ID Buku yang ingin anda kembalikan: ");
                    int id = input.nextInt();
                    library.returnBook(library.semuaBuku, id);
                } case 0 -> {
                    jalan = false;
                    System.out.println("========== SELAMAT DATANG KEMBALI! ==========");
                }
            }
        }
    }
}
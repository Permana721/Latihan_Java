package Java_OOP._6_Perpustakaan;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> semuaBuku = new ArrayList<>();
    boolean ditemukan = false;

    public ArrayList<Book> addBook(){
        semuaBuku.add(new Book(1, "Madilog", "Tan Malaka"));
        semuaBuku.add(new Book(2, "Seporsi Mie Ayam Sebelum Mati", "Brian Khrisna"));
        semuaBuku.add(new Book(3, "Filosofi Teras", "Henry Manampiring"));
        semuaBuku.add(new Book(4, "Ruri Sinaga", "Masaki Shindo"));
        semuaBuku.add(new Book(5, "Jujutsu Kaisen", "Gege Akutami"));

        return semuaBuku;
    }

    public void borrowBook(ArrayList<? extends Book> list, int id){
        for (Book book : list){
            if(book.getId() == id){
                ditemukan = true;

                if (book.getAvaible() == false){
                    System.out.println("Buku sudah anda pinjam! \n");
                } else if(book.getAvaible() == true) {
                    System.out.println("Berhasil meminjam buku! \nNama: " + book.getTitle() + "\nDari Author: " + book.getAuthor() + "\n");
                    book.setAvaible(false);
                }
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Buku dengan ID tersebut tidak ditemukan! \n");
        }
    }

    public void returnBook(ArrayList<? extends Book> list, int id){
        for (Book book : list){
            if (book.getId() == id){
                ditemukan = true;

                if (book.getAvaible() == true){
                    System.out.println("Buku belum anda pinjam! \n");
                } else if(book.getAvaible() == false) {
                    System.out.println("Berhasil mengembalikan buku! \nNama: " + book.getTitle() + "\nDari Author: " + book.getAuthor() + "\n");
                    book.setAvaible(true);
                }
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Buku dengan ID tersebut tidak ditemukan! \n");
        }
    }

    public void searchBook(String nama){
        for (Book buku : semuaBuku){
            if (buku.getTitle().equalsIgnoreCase(nama)){
                System.out.println("Hasil Pencarian: " + "\nID: " + buku.getId() + "\nNama: " + buku.getTitle() + "\nAuthor: " + buku.getAuthor() + "\n");
                return;
            }
        }
        System.out.println("Buku tidak ditemukan");
    }

    public void getCollectionBook(){
        for (Book buku : semuaBuku){
            if (buku.getAvaible() == false){
                buku.tampilBuku();
                System.out.println("-----------------------------------");
            } else {
                System.out.println("Anda belum meminjam buku!");
            }
        }
    }
}

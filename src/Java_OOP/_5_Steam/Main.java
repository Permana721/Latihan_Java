package Java_OOP._5_Steam;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        boolean jalan = true;
        Store store = new Store();
        ArrayList<Game> semuaGame = store.tambahGame();
        Scanner input = new Scanner(System.in);
        User user = new User("Permana", 2_000_000);
        user.setSaldo(10_000);

        while (jalan){
            System.out.println("\n");
            System.out.println("User: " + user.getNamaUser());
            System.out.println("Saldo awal: " + user.getSaldo());
            System.out.println("Menu: \n1. Lihat game \n2. Beli game \n3. Cari game \n4. Koleksi \n5. Tambah saldo \n0. Keluar");
            System.out.print("Pilih: ");
            int pilihan = input.nextInt();
            input.nextLine();
            System.out.println("\n");

            switch (pilihan){
                case 1 -> {
                    System.out.println("========== DAFTAR GAME MANA STORE ==========");
                    for (Game games : semuaGame) {
                        games.tampilGame();
                        System.out.println("---------------------------------------");
                    }
                } case 2 -> {
                    System.out.println("Masukan ID game yang ingin anda beli");
                    int id = input.nextInt();
                    user.beliGame(store.semuaGame, id);
                } case 3 -> {
                    System.out.println("Masukkan nama game yang ingin anda cari: ");
                    String nama = input.nextLine();
                    store.cariGameByNama(nama);
                } case 4 -> {
                    user.getKoleksi();
                } case 5 -> {
                    System.out.println("Masukan nominal yang anda inginkan: ");
                    int tmbhSaldo = input.nextInt();
                    user.setSaldo(tmbhSaldo);
                    System.out.println("Saldo anda sekarang adalah " + user.getSaldo());
                } case 0 -> {
                    jalan = false;
                }
                default -> System.out.println("Tolong masukan input yang valid!");
            }
        }
    }
}

package Java_OOP._5_Steam;

import java.util.ArrayList;

public class User {
    private String namaUser;
    private int saldo;
    ArrayList<Game> koleksi = new ArrayList<>();

    public User(String namaUser, int saldo){
        this.namaUser = namaUser;
        this.saldo = saldo;
    }

    public String getNamaUser(){
        return namaUser;
    }

    public int getSaldo(){
        return saldo;
    }

    public void setSaldo(int saldo){
        this.saldo += saldo;
    }

    public void getKoleksi(){
        if (koleksi.size() == 0) {
            System.out.println("Koleksi kamu masih kosong. Ayo beli game dulu!");
            return;
        }

        System.out.println("=== Koleksi Game Kamu ===");
        for(int i = 0; i < koleksi.size(); i++){
            koleksi.get(i).tampilGame();
        }
    }

    public void beliGame(ArrayList<? extends Game> list, int id){
        boolean ditemukan = false;
        for (Game games : list) {
            if (games.getIdGame() == id) {
                ditemukan = true;

                boolean sudahDibeli = false;
                for (Game k : koleksi) {
                    if (k.getIdGame() == id) {
                        sudahDibeli = true;
                        break;
                    }
                }

                if (sudahDibeli) {
                    System.out.println("Game sudah ada di koleksi Anda!");
                } else if (saldo >= games.getHargaGame()) {
                    saldo -= games.getHargaGame();
                    koleksi.add(games);
                    System.out.println("Berhasil membeli Game: " + games.getNamaGame()
                            + "\nDengan harga: " + games.getHargaGame()
                            + "\nSisa saldo: " + getSaldo());
                } else {
                    System.out.println("Maaf, saldo tidak cukup. Kurang: Rp. "
                            + (games.getHargaGame() - getSaldo()));
                }
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Game dengan ID tersebut tidak ditemukan!");
        }
    }
}

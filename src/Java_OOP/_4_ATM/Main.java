package Java_OOP._4_ATM;

public class Main {
    static void main(String[] args) {
//        AkunBank[] daftarAkun = new AkunBank[3];
//        daftarAkun[0] = new AkunBank("Permana", 100_000);
//        daftarAkun[1] = new AkunBank("Arido", 200_000);
//        daftarAkun[2] = new AkunBank("Umam", 500_000);
//
//        daftarAkun[0].tarik(50_000);
//        daftarAkun[1].tarik(100_000);

//        for(int i = 0; i < daftarAkun.length; i++){
//            daftarAkun[i].tampilInfo();
//        }

        AkunTabungan tabungan = new AkunTabungan("Permana", 200_000, 6);
        tabungan.setor(50_000);
        tabungan.hitungBunga();
        tabungan.tampilInfo();
    }
}

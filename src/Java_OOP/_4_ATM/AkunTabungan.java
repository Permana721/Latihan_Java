package Java_OOP._4_ATM;

public class AkunTabungan extends AkunBank {
    private int bunga;

    AkunTabungan(String namaPemilik, int saldo, int bunga){
        super(namaPemilik, saldo);
        this.bunga = bunga;
    }

    public int getBunga(){
        return bunga;
    }

    public void hitungBunga() {
        int bungaUang = getSaldo() * bunga / 100;
        System.out.println("Bunga: " + bungaUang);
    }
}

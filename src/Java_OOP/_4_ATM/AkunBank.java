package Java_OOP._4_ATM;

public class AkunBank {
    private String namaPemilik;
    private int saldo;

    AkunBank(String namaPemilik, int saldo){
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    public String getNamaPemilik(){
        return namaPemilik;
    }

    public int getSaldo(){
        return saldo;
    }

    public void setor(int saldo){
        this.saldo += saldo;
    }

    public void tarik(int jumlah){
        if(saldo < jumlah){
            System.out.println("Maaf! Saldo anda tidak cukup");
        } else {
            this.saldo -= jumlah;
        }
    }

    public void tampilInfo(){
        System.out.println("Nama: " + getNamaPemilik());
        System.out.println("Saldo: " + getSaldo());
    }
}

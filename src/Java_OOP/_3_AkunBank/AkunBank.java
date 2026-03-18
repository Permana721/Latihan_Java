package Java_OOP._3_AkunBank;

public class AkunBank {
    private double saldo;
    private String namaPemilik;

    public double getSaldo(){
        return saldo;
    }

    public String getNamaPemilik(){
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik){
        this.namaPemilik = namaPemilik;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public void Setor(double jumlah){
        saldo += jumlah;
    }

    public void Tarik(double jumlah){
        if(saldo > jumlah){
            System.out.println("Saldo anda tidak cukup!");
        } else {
            saldo -= jumlah;
        }
    }

    public void tampilInfo(){
        System.out.println("Nama: " + this.getNamaPemilik());
        System.out.println("Saldo: " + getSaldo());
    }
}

package Java_OOP._3_AkunBank;

public class AkunBankApp {
    public static void main(String[] args) {
        AkunBank akunBank = new AkunBank();

        akunBank.setSaldo(100_000);
        akunBank.Setor(200_000);
        akunBank.Tarik(290_000);
        akunBank.setNamaPemilik("Permana");
        akunBank.tampilInfo();
    }
}

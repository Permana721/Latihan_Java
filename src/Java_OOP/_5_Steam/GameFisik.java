package Java_OOP._5_Steam;

public class GameFisik extends Game{

    GameFisik(int idGame, String namaGame, int hargaGame){
        super(idGame, namaGame, hargaGame);
    }

    public void tampilGame(){
        super.tampilGame();
        System.out.println("Tipe: Fisik \nJenis: " + "CD");
    }
}

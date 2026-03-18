package Java_OOP._5_Steam;

public class GameDigital extends Game{
    private int sizeGB;

    GameDigital(int idGame, String namaGame, int hargaGame, int sizeGB){
        super(idGame, namaGame, hargaGame);
        this.sizeGB = sizeGB;
    }

    public int getSizeGB(){
        return sizeGB;
    }

    public void tampilGame(){
        super.tampilGame();
        System.out.println("Tipe: Digital \nSize: " + getSizeGB() + " GB");
    }
}

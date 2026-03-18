package Java_OOP._2_PersegiPanjang;

public class PersegiPanjang {
    private int panjang;
    private int lebar;

    PersegiPanjang(){
    }

    PersegiPanjang(int panjang, int lebar){
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public int hitungLuas(){
        return panjang * lebar;
    }

    public int hitungKeliling(){
        return (2 * panjang) + (2 * lebar);
    }
}

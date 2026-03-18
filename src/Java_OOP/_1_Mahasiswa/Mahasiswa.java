package Java_OOP._1_Mahasiswa;

public class Mahasiswa {
    private String name;
    private int nim;
    private String prodi;

    Mahasiswa(String name, int nim, String prodi){
        this.name = name;
        this.nim = nim;
        this.prodi = prodi;
    }

    public String getName(){
        return name;
    }

    public int getNim(){
        return nim;
    }

    public String getProdi(){
        return prodi;
    }
}

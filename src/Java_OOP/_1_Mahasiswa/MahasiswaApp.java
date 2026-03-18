package Java_OOP._1_Mahasiswa;

public class MahasiswaApp {
    static void main(String[] args) {
        var mahasiswa = new Mahasiswa("Permana Surya Dharma", 12345, "Informatika");

        System.out.println("Nama: " + mahasiswa.getName());
        System.out.println("NIM: " + mahasiswa.getNim());
        System.out.println("Prodi: " + mahasiswa.getProdi());
    }
}
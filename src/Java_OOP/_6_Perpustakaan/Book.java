package Java_OOP._6_Perpustakaan;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean avaible = true;

    Book(int id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public Boolean getAvaible(){
        return avaible;
    }

    public boolean setAvaible(boolean status){
        return this.avaible = status;
    }

    public String getAuthor(){
        return author;
    }

    public void tampilBuku(){
        System.out.println("ID: " + getId());
        System.out.println("Nama: " + getTitle());
        System.out.println("Author: " + getAuthor());
    }


}

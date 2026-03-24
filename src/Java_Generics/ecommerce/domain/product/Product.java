package Java_Generics.ecommerce.domain.product;

public class Product {
    private int id;
    private String name;
    private int price;
    private Category category;

    public Product(int id, String laptop, int price) {

    }

    public Product(int id, String name, int price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void printInfo(){
        System.out.println("Nama: " + name);
        System.out.println("Harga: " + price);
        System.out.println("Kategori: " + category.getDescription());
        System.out.println("===========================");
    }
}
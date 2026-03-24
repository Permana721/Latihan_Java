package Java_Generics.ecommerce.domain.product;

public enum Category {
    ELECTRONICS("Electronic"),
    FOOD("Food"),
    FASHION("Fashion"),
    GROCERIES("Groceries");

    private String description;

    Category(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

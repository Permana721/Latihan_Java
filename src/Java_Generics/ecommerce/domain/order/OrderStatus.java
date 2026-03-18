package Java_Generics.ecommerce.domain.order;

public enum OrderStatus {
    PACKED("Packed"),
    SENT("Sent"),
    OTW("On The Way"),
    DELIVERED("Delivered");

    private String description;

    OrderStatus(String description) {
        this.description = description;
    }
}

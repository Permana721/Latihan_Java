package Java_Generics.ecommerce.domain.payment;

public enum PaymentMethod {
    BANK("Bank"),
    QRIS("Qris"),
    TUNAI("Tunai");

    private String description;

    PaymentMethod(String description) {
        this.description = description;
    }
}

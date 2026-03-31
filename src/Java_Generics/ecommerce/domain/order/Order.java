package Java_Generics.ecommerce.domain.order;

public class Order {
    private String daftarItem;
    private int totalHarga;
    private OrderStatus status;

    public Order(String daftarItem, int totalHarga, OrderStatus status) {
        this.daftarItem = daftarItem;
        this.totalHarga = totalHarga;
        this.status = status;
    }

    public String getDaftarItem() {
        return daftarItem;
    }

    public void setDaftarItem(String daftarItem) {
        this.daftarItem = daftarItem;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

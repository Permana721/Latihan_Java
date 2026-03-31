package Java_Generics.ecommerce.domain.payment;

public class Payment {
    private int jmlBayar;
    private PaymentMethod metode;

    public Payment(int jmlBayar, PaymentMethod metode) {
        this.jmlBayar = jmlBayar;
        this.metode = metode;
    }

    public int getJmlBayar() {
        return jmlBayar;
    }

    public void setJmlBayar(int jmlBayar) {
        this.jmlBayar = jmlBayar;
    }

    public PaymentMethod getMetode() {
        return metode;
    }

    public void setMetode(PaymentMethod metode) {
        this.metode = metode;
    }
}

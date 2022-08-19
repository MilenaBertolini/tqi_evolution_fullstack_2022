package API.Library.model;

import javax.persistence.*;

@Entity(name = "transactions")
public class TransactionsModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false)
    private int idProduct;

    @Column (nullable = false)
    private int idClient;

    @Column (nullable = false)
    private int quantity;

    @Column (nullable = false)
    private double price;

    @Column (nullable = false)
    private boolean sell;

    @Column (nullable = false)
    private boolean buy;

    public int getId() {
        return id;
    }


    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSell() {
        return sell;
    }

    public void setSell(boolean sell) {
        this.sell = sell;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }
}

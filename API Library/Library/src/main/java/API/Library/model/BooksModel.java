package API.Library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name = "books")
public class BooksModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (nullable = false, length = 500)
    private String title;
    @Column (nullable = false, length = 500)
    private String author;
    @Column (nullable = false, length = 500)
    private String publisher;
    @Column (nullable = false)
    private int publishYear;
    @Column (nullable = false, length = 10, precision = 2)
    private double price;
    @Column (nullable = false)
    private int quantity;

    @Lob
    @Column (nullable = false)
    private byte[] image;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

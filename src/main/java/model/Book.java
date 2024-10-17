package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    private String book_id;
    private String title;
    private double price;

    public Book() {
    }

    public Book(String book_id, String title, double price) {
        this.book_id = book_id;
        this.title = title;
        this.price = price;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id='" + book_id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}

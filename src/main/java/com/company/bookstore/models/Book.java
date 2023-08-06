package com.company.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;
    private String isbn;
    private String publishDate;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private String title;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
    private Float price;

    public Book(){};

    public Book(int id, String isbn, String publishDate, Author author, String title, Publisher publisher, float price) {
        this.id = id;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublishDate() {
        return publishDate;
    }


    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisherId(Publisher publisher) {
        this.publisher = publisher;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && author == book.author && publisher == book.publisher && Objects.equals(isbn, book.isbn) && Objects.equals(publishDate, book.publishDate) && Objects.equals(title, book.title) && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, publishDate, author, title, publisher, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", publishDate=" + publishDate +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", publisher=" + publisher +
                ", price=" + price +
                '}';
    }
}

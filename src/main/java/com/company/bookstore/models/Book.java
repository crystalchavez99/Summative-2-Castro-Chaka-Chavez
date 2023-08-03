package com.company.bookstore.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Book {
    private String id;
    private String isbn;
    private String publishDate;
    private int authorId;
    private String title;
    private int publisherId;
    private Float price;

    public Book(String id, String isbn, String publishDate, int authorId, String title, int publisherId, float price) {
        this.id = id;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.authorId = authorId;
        this.title = title;
        this.publisherId = publisherId;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
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
        return id == book.id && authorId == book.authorId && publisherId == book.publisherId && Objects.equals(isbn, book.isbn) && Objects.equals(publishDate, book.publishDate) && Objects.equals(title, book.title) && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, publishDate, authorId, title, publisherId, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", publishDate=" + publishDate +
                ", authorId=" + authorId +
                ", title='" + title + '\'' +
                ", publisherId=" + publisherId +
                ", price=" + price +
                '}';
    }
}

package com.company.bookstore.repository;

import com.company.bookstore.models.Book;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;




@Component
public class BookRepository {

    public BookRepository(){ seedDataStore();}

    public List<Book> books = new ArrayList<Book>();

    private void seedDataStore(){
        Book b1 = new Book("1", "0987654321", "2023-08-05", 1, "Head First Java", 1, 24.99f);
        Book b2 = new Book("2", "01234567890", "2023-08-05", 2, "Crack Code Interview", 1, 39.99f);
        this.books.add(b1);
        this.books.add(b2);
    }

    // Get all books
    public List<Book> getBooks() {return this.books;}

    public Book getBookByAuthorId(String authorId){
        List<Book> checkId = this.books;
        Book foundBook = null;
        for(Book b : checkId){
            if(b.getId().equals(authorId)){
                foundBook = b;
            }
        }
        return foundBook;
    }

    // Get book by id
    public Book getBookById(String id){
        List<Book> checkId = this.books;
        Book foundBook = null;
        for(Book b : checkId){
            if(b.getId().equals(id)){
                foundBook = b;
            }
        }
        return foundBook;
    }

    // create a new book
    public Book addBook(String id, String isbn, String publishDate, int authorId, String title, int publisherId, float price){
        Book newBook = new Book(id, isbn, publishDate, authorId, title, publisherId, price);
        System.out.println(newBook);
        this.books.add(newBook);
        return newBook;

    }

    // update a book
    public Book updateBook(Book book){
        for(Book b: books){
            int indexNumber = -1;
            if(b.getId().equals(book.getId())){
                indexNumber = books.indexOf(b);
                books.set(indexNumber,book);
                return book;
            }
        }
        return null;
    }

    // delete book by id
    public boolean deleteBookById(String id){
        for(Book b: books){
            int indexNumber = -1;
            if(b.getId().equals(id)){
                indexNumber = books.indexOf(b);
                books.remove(indexNumber);
                return true;
            }
        }
        return false;
    }
}

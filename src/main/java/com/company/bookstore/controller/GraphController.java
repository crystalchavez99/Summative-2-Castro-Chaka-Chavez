package com.company.bookstore.controller;

import com.company.bookstore.models.Book;
import com.company.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;



@Controller
public class GraphController {



    @Autowired
    BookRepository bookRepository;

    @QueryMapping
    public List<Book> books(){
        return bookRepository.getBooks();
    }

    @QueryMapping
    public Book findBookById(@Argument String id){
        return bookRepository.getBookById(id);
    }

//    @QueryMapping
//    public Book findBookByAuthorId(@Argument String authorId){
//        return bookRepository.
//    }

    @MutationMapping
    public Book addBook(
            @Argument String id,
            @Argument String isbn,
            @Argument String publishDate,
            @Argument int authorId,
            @Argument String title,
            @Argument int publisherId,
            @Argument float price
            ){
        return bookRepository.addBook(id,isbn,publishDate,authorId, title,publisherId,price);
    }

    @MutationMapping
    public Book updateBook(
            @Argument String id,
            @Argument String isbn,
            @Argument String publishDate,
            @Argument int authorId,
            @Argument String title,
            @Argument int publisherId,
            @Argument float price
    ){
        Book updateBook = new Book(id,isbn,publishDate,authorId, title,publisherId,price);
        return bookRepository.updateBook(updateBook);
    }

    @MutationMapping
    public boolean deleteBookById(@Argument String id){
        return bookRepository.deleteBookById(id);
    }
}

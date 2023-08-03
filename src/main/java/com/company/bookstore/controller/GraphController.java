package com.company.bookstore.controller;

import com.company.bookstore.models.Book;
import com.company.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.company.bookstore.models.Publisher;
import com.company.bookstore.repository.PublisherRepository;

import java.time.LocalDate;
import java.util.List;

@Controller
public class GraphController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PublisherRepository publisherRepository;


    @QueryMapping
    public List<Book> books(){
        return bookRepository.getBooks();
    }

    @QueryMapping
    public Book findBookById(@Argument String id){
        return bookRepository.getBookById(id);
    }

    @MutationMapping
    public Book addBook(
            @Argument String id,
            @Argument String isbn,
            @Argument LocalDate publishDate,
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
            @Argument LocalDate publishDate,
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


//PublisherController

    @QueryMapping
    public List<Publisher> publishers() {
        return publisherRepository.getAllPublishers();
    }

    @QueryMapping
    public Publisher findPublisherById(@Argument String id) {
        return publisherRepository.getPublisherById(id);
    }

    @MutationMapping
    public Publisher addPublisher(
            @Argument String name,
            @Argument String street,
            @Argument String city,
            @Argument String state,
            @Argument String postalCode,
            @Argument String phone,
            @Argument String email
    ) {
        Publisher newPublisher = new Publisher();
        newPublisher.setName(name);
        newPublisher.setStreet(street);
        newPublisher.setCity(city);
        newPublisher.setState(state);
        newPublisher.setPostalCode(postalCode);
        newPublisher.setPhone(phone);
        newPublisher.setEmail(email);
        return publisherRepository.addPublisher(newPublisher);
    }

    @MutationMapping
    public Publisher updatePublisher(
            @Argument String name,
            @Argument String street,
            @Argument String city,
            @Argument String state,
            @Argument String postalCode,
            @Argument String phone,
            @Argument String email
    ) {
        Publisher updatePublisher = new Publisher();
        updatePublisher.setName(name);
        updatePublisher.setStreet(street);
        updatePublisher.setCity(city);
        updatePublisher.setState(state);
        updatePublisher.setPostalCode(postalCode);
        updatePublisher.setPhone(phone);
        updatePublisher.setEmail(email);
        return publisherRepository.updatePublisher(updatePublisher);
    }

    @MutationMapping
    public boolean deletePublisherById(@Argument String id) {
        return publisherRepository.deletePublisherById(id);
    }


}




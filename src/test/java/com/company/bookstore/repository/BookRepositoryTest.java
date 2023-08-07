package com.company.bookstore.repository;

import com.company.bookstore.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    private Book book;

    @BeforeEach
    public void setUp() {
        bookRepository.deleteAll();

        book = new Book();
        book.setAuthorId(1);
        book.setIsbn("1357924680");
        book.setPrice(new BigDecimal(29.99));
        book.setTitle("Algorithms");
        book.setPublisherId(1);
        book.setPublishDate(new Date(2023-01-05));

        book = bookRepository.save(book);
    }

    @Test
    void createBook(){
        Optional<Book> book2 = bookRepository.findById(book.getId());
        assertEquals(book2.get(), book);
    }

    @Test
    void findBookByBookId() {
        Optional<Book> book2 = bookRepository.findById(book.getId());
        assertEquals(book2.get(), book);
    }

    @Test
    void findAllBooks(){
        List<Book> books = bookRepository.findAll();
        assertEquals(1,books.size());
    }

    @Test
    void updateBook(){
        book.setTitle("UPDATED");

        bookRepository.save(book);

        Optional<Book> book2 = bookRepository.findById(book.getId());
        assertEquals(book2.get(), book);
    }

    @Test
    void deleteBookById(){
        bookRepository.deleteById(book.getId());

        Optional<Book> book2 = bookRepository.findById(book.getId());
        assertFalse(book2.isPresent());
    }
    @Test
    void findBooksByAuthorId() {
        List<Book> books = bookRepository.findByAuthorId(book.getAuthorId());
        assertEquals(1, books.size());
    }
}
package com.webservices.restWebServices.resources;

import com.webservices.restWebServices.Dao.BookRepository;
import com.webservices.restWebServices.model.Book;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import javax.ws.rs.core.Response;
import java.util.List;


public class BookResourceImpl implements BookResource{

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BookRepository bookRepository;

    //method to add book
    @Override
    public Response addBook(Book book) {
        Book bookExists = bookRepository.findByIsbn(book.getIsbn());
        if(bookExists != null) {
            return Response.status(Response.Status.CONFLICT).build();
        } else {
            bookRepository.save(book);
            return Response.ok("Book with ISBN " + book.getIsbn() + " added successfully.").build();
        }
    }

    //method to show all the books added
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //method to show book of particular isbn
    @Override
    public Book getBookByIsbn(Long isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    //method to delete book
    //isbn is used to decide which book to delete
    @Override
    public Response deleteBookByIsbn(Long isbn) {
        Book isbnExistence = bookRepository.findByIsbn(isbn);
        System.out.println(isbnExistence);
        if(isbnExistence == null){
            return Response.status(Response.Status.NOT_FOUND).entity("ISBN is not found").build();
        } else {
            bookRepository.deleteById(isbn);
            return Response.ok("Book with ISBN " + isbn + " deleted Successfully.").build();
        }

    }

    //update book details
    @Override
    public Response updateBook(Long isbn, Book book) {
        Book isbnExistence = bookRepository.findByIsbn(isbn);
        System.out.println(isbnExistence);
        if(isbnExistence == null){
            return Response.status(Response.Status.NOT_FOUND).entity("ISBN is not found").build();
        } else {
            book.setIsbn(isbn);
            bookRepository.save(book);
            return Response.ok("Book with ISBN " +isbn+ " is updated. " ).build();
        }

    }



}

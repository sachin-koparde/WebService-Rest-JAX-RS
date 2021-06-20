package com.webservices.restWebServices.resources;

import com.webservices.restWebServices.Dao.BookRepository;
import com.webservices.restWebServices.model.Book;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;


public class BookResourceImpl implements BookResource{

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BookRepository bookRepository;

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

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookByIsbn(@PathParam("isbn") Long isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public Response deleteBookByIsbn(@PathParam("isbn") Long isbn) {
        Book isbnExistence = bookRepository.findByIsbn(isbn);
        System.out.println(isbnExistence);
//        if(isbnExistence == null){
//            return Response.status(Response.Status.NOT_FOUND).entity("ISBN is not found").build();
//        } else {
            bookRepository.deleteById(isbn);
            return Response.ok("Book with ISBN " + isbn + " Deleted Successfully.").build();
//        }

    }

    @Override
    public Response updateVintage(@PathParam("isbn") Long isbn, Book book) {
        book.setIsbn(isbn);
        bookRepository.save(book);
        return Response.ok("Book with ISBN " +isbn+ " is updated. " ).build();
    }



}

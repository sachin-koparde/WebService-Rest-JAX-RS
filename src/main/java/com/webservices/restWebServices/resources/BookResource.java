package com.webservices.restWebServices.resources;

import com.webservices.restWebServices.Dao.BookDao;
import com.webservices.restWebServices.model.Book;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class BookResource {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BookDao bookDao;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/addBook")
    public Book addBook(Book book) {
        return bookDao.save(book);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/showAllBooks")
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/showBook/{isbn}")
    public Book getBookByIsbn(@PathParam("isbn") Long isbn) {
        return bookDao.findByIsbn(isbn);
    }

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteBook/{isbn}")
    public Response deleteBookByIsbn(@PathParam("isbn") Long isbn) {
        bookDao.deleteById(isbn);
        return Response.ok("Book Deleted Successfully\nISBN: " + isbn).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/updateVintage/{isbn}")
    public Response updateVintage(@PathParam("isbn") Long isbn, Book book) {
        book.setIsbn(isbn);
        bookDao.save(book);
        return Response.ok("Book with ISBN " +isbn+ " is updated. " ).build();
    }



}

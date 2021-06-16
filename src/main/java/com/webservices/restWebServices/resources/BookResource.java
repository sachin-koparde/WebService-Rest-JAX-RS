package com.webservices.restWebServices.resources;

import com.webservices.restWebServices.model.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public interface BookResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/addBook")
    Response addBook(Book book);

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/showAllBooks")
    List<Book> getAllBooks();

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/showBook/{isbn}")
    Book getBookByIsbn(@PathParam("isbn") Long isbn);

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteBook/{isbn}")
    Response deleteBookByIsbn(@PathParam("isbn") Long isbn);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/updateVintage/{isbn}")
    Response updateVintage(@PathParam("isbn") Long isbn, Book book);

}

package com.webservices.restWebServices.resources;

import com.webservices.restWebServices.model.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public interface BookResource {

    /*The @Consumes annotation is used to specify which MIME media types of representations a resource can accept,
    or consume, from the client. If @Consumes is applied at the class level, all the response methods accept the
    specified MIME types by default.

    The @Produces annotation is used to specify the MIME media types or representations a resource can produce
    and send back to the client.If @Produces is applied at the class level, all the methods in a resource can
    produce the specified MIME types by default.*/
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
    Response updateBook(@PathParam("isbn") Long isbn, Book book);

}

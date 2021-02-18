package com.rolon.quarkus.controller;

import com.rolon.quarkus.data.Book;
import com.rolon.quarkus.service.IBookService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
public class BookController {
    @Inject
    IBookService bookService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> listBooks() {
        return bookService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Book lisBooks(@PathParam("id") Integer id) {
        return bookService.findByID(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Book saveBook(Book book){
       return bookService.save(book);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("/{id}")
    public Book deleteBook(@PathParam("id") Integer id){
        return bookService.deleteByID(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("/{id}")
    public Book updateBook(@PathParam("id") Integer id, Book book){
        return bookService.updateByID(id,book);
    }
}

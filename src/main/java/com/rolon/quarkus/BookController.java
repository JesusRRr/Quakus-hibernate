package com.rolon.quarkus;

import com.rolon.quarkus.data.Book;
import com.rolon.quarkus.repository.BookRepository;
import com.rolon.quarkus.service.BookService;
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Book saveBook(Book book){
       return bookService.save(book);
    }
}

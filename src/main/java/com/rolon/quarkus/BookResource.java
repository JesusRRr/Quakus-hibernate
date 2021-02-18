package com.rolon.quarkus;

import com.rolon.quarkus.data.Book;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/book")
public class BookResource {
    @Inject
    EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> listBooks() {
        return entityManager.createQuery("Select b from Book b", Book.class).getResultList();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Book saveBook(Book book){
        entityManager.persist(book);
        return book;
    }
}
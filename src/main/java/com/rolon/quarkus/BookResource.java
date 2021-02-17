package com.rolon.quarkus;

import com.rolon.quarkus.data.Book;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/book")
public class BookResource {
    @Inject
    EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List<Book> hello() {
        return entityManager.createQuery("Select b from Book b", Book.class).getResultList();
    }
}
package com.rolon.quarkus;

import com.rolon.quarkus.data.Author;
import com.rolon.quarkus.service.AuthorService;
import javafx.application.Application;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/authors")
public class AuthorController {
    @Inject
    AuthorService authorService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> listAuthors(){
        return authorService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Author saveAuthor(Author author){
        return authorService.save(author);
    }
}

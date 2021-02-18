package com.rolon.quarkus;

import com.rolon.quarkus.data.Author;
import com.rolon.quarkus.service.AuthorService;
import javafx.application.Application;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/authors")
public class AuthorController {
    @Inject
    AuthorService authorService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> listAuthors(){

    }
}

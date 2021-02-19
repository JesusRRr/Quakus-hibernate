package com.rolon.quarkus.controller;

import com.rolon.quarkus.data.Author;
import com.rolon.quarkus.service.author.AuthorService;

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
        return authorService.secureSave(author);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Author getAuthorByName(@PathParam("name") String name){
        System.out.println(name);
       return authorService.findByName(name);
    }


}

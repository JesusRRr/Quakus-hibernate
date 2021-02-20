package com.rolon.quarkus.service.author;

import com.rolon.quarkus.data.Author;
import com.rolon.quarkus.repository.AuthorRepository;
import org.springframework.data.jpa.repository.Query;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Locale;

@ApplicationScoped
public class AuthorService implements IAuthorService{
    @Inject
    AuthorRepository authorRepository;
    @Override
    public List<Author> findAll() {
        return (List<Author>) authorRepository.findAll();
    }

    @Override
    public Author findByID(Integer id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author deleteByID(Integer id) {
        Author author = findByID(id);
        return author;
    }

    @Override
    public Author updateByID(Integer id, Author author) {
        deleteByID(id);
        return save(author);
    }


    @Override
    public Author save(Author author) {

        return authorRepository.save(author);
    }

    /*public boolean authorExists(Author author){
        authorRepository.findByFullName()
    }*/


    public Author findByName(String name){
        return authorRepository.findByName(name);
    }

    public Author findByLastName(String lastName){
        return authorRepository.findByLastName(lastName);
    }

    public Author findByFullName(String name,String lastName){
        return authorRepository.findByLastnameAndFirstname(name, lastName);
    }

    public Author secureSave(Author author){
        return findByFullName(author.getName(),author.getLastName());
    }

}

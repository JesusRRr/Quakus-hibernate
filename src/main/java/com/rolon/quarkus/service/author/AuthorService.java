package com.rolon.quarkus.service.author;

import com.rolon.quarkus.data.Author;
import com.rolon.quarkus.repository.AuthorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

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

    public Author findByFullName(String name, String lastName){
        Author authorFound = authorRepository.findByName(name);
        String authorName = authorFound.getName();
        String authorLastName = authorFound.getLastName();
        if(authorName.equals(name) && authorLastName.equals(lastName)){
            return authorFound;
        }else{
            return null;
        }
    }
}

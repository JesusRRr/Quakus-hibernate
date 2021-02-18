package com.rolon.quarkus.service;

import com.rolon.quarkus.data.Author;

import java.util.List;

public interface IAuthorService {
    public List<Author> findAll();
    public Author findByID(Integer id);
    public Author deleteByID(Integer id);
    public Author updateByID(Integer id, Author author);
    public Author save(Author author);
}

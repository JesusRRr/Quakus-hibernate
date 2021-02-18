package com.rolon.quarkus.service;

import com.rolon.quarkus.data.Book;
import com.rolon.quarkus.repository.BookRepository;

import java.util.List;

public interface IBookService{
    public List<Book> findAll();
    public Book findByID(Integer id);
    public Book deleteByID(Integer id);
    public Book updateByID(Integer id);
    public Book save(Book book);

}

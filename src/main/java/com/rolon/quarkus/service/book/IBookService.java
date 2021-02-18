package com.rolon.quarkus.service.book;

import com.rolon.quarkus.data.Book;
import com.rolon.quarkus.repository.BookRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;


public interface IBookService{
    public List<Book> findAll();
    public Book findByID(Integer id);
    public Book deleteByID(Integer id);
    public Book updateByID(Integer id, Book book);
    public Book save(Book book);
}

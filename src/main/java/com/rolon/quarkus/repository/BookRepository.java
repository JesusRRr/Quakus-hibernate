package com.rolon.quarkus.repository;

import com.rolon.quarkus.data.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Integer>{
    public List<Book> findAll();
}

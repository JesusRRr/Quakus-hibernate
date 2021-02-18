package com.rolon.quarkus.repository;

import com.rolon.quarkus.data.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Integer, Book> {
}

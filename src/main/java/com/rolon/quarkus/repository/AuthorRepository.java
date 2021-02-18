package com.rolon.quarkus.repository;

import com.rolon.quarkus.data.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}

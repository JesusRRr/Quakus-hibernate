package com.rolon.quarkus.repository;

import com.rolon.quarkus.data.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
    public Author findByName(String name);
    public Author findByLastName(String lastName);

    @Query("select u from Author u where u.name = :name and u.lastName = :lastName")
    Author findByLastnameAndFirstname(@Param("name")String name,@Param("lastName")  String lastname);
}

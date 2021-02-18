package com.rolon.quarkus.data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, fetch =FetchType.EAGER ,orphanRemoval = true, mappedBy = "author")
    private List<Book> books;

    public Integer getId() {
        return id;
    }

    public Author() {
    }

    public Author(Integer id, String name, String lastName, List<Book> books) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.books = books;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(name, author.name) && Objects.equals(lastName, author.lastName) && Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, books);
    }
}

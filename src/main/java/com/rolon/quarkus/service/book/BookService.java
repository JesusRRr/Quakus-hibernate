package com.rolon.quarkus.service.book;

import com.rolon.quarkus.data.Book;
import com.rolon.quarkus.repository.BookRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BookService implements IBookService{
    @Inject
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book findByID(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book deleteByID(Integer id) {
        Book book = findByID(id);
        bookRepository.delete(book);
        return book;
    }

    public Book updateByID(Integer id, Book book) {
        deleteByID(id);
        return save(book);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}

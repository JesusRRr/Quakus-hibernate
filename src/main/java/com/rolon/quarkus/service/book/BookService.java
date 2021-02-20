package com.rolon.quarkus.service.book;

import com.rolon.quarkus.data.Author;
import com.rolon.quarkus.data.Book;
import com.rolon.quarkus.repository.AuthorRepository;
import com.rolon.quarkus.repository.BookRepository;
import com.rolon.quarkus.service.author.AuthorService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BookService implements IBookService{
    @Inject
    BookRepository bookRepository;

    @Inject
    AuthorService authorService;

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
        Author author = authorService.save(book.getAuthor());
        return bookRepository.save(book);
    }
}

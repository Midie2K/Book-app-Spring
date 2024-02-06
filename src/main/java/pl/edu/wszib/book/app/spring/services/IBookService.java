package pl.edu.wszib.book.app.spring.services;

import pl.edu.wszib.book.app.spring.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    Optional<Book> getById(int id);
    List<Book> getAll();
    List<Book> getByPattern(String pattern);
    void persist(Book book);
    void initInDB();
    void update(Book book);
}

package pl.edu.wszib.book.app.spring.services;

import pl.edu.wszib.book.app.spring.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
}

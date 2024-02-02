package pl.edu.wszib.book.app.spring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.book.app.spring.dao.IBookDAO;
import pl.edu.wszib.book.app.spring.model.Book;
import pl.edu.wszib.book.app.spring.services.IBookService;

import java.util.List;
@Service
public class BookService implements IBookService {
    @Autowired
    IBookDAO bookDAO;

    @Override
    public List<Book> getAll() {
        return bookDAO.getAll();
    }
}

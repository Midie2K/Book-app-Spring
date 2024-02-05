package pl.edu.wszib.book.app.spring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.book.app.spring.dao.IBookDAO;
import pl.edu.wszib.book.app.spring.model.Book;
import pl.edu.wszib.book.app.spring.services.IBookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookDAO bookDAO;

    @Override
    public Optional<Book> getById(int id) {
        return this.bookDAO.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDAO.getAll();
    }

    @Override
    public void persist(Book book) {
        this.bookDAO.persist(book);
    }

    @Override
    public void InitInDB() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Java: The Complete Reference, Twelfth Edition",
                "Herbert Schildt","978-83-832-2156-4",true));
        books.add(new Book("C# 12 in a Nutshell",
                "Joseph Albahari","978-10-981-4740-2",true));
        books.add(new Book("Python Data Science Handbook: Essential Tools for Working with Data, 2nd Edition",
                "Jake VanderPlas","978-83-289-0068-4",true));
        books.add(new Book( "SQL QuickStart Guide: The Simplified Beginner's Guide to Managing, Analyzing, and Manipulating Data With SQL",
                "Walter Shields","978-83-832-2657-6",true));

        for(Book book : books){
            this.bookDAO.persist(book);
        }
    }

    @Override
    public void update(int bookId) {
        //TODO
    }
}

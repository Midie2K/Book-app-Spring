package pl.edu.wszib.book.app.spring.dao.impl.memory;

import org.springframework.stereotype.Repository;
import pl.edu.wszib.book.app.spring.dao.IBookDAO;
import pl.edu.wszib.book.app.spring.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository implements IBookDAO {
    private final List<Book> books = new ArrayList<>();

    public BookRepository(){
        this.books.add(new Book(1,"Java: The Complete Reference, Twelfth Edition",
                                "Herbert Schildt","978-83-832-2156-4",true));
        this.books.add(new Book(2,"C# 12 in a Nutshell",
                                "Joseph Albahari","978-10-981-4740-2",true));
        this.books.add(new Book(3,"Python Data Science Handbook: Essential Tools for Working with Data, 2nd Edition",
                                "Jake VanderPlas","978-83-289-0068-4",true));
        this.books.add(new Book(4, "SQL QuickStart Guide: The Simplified Beginner's Guide to Managing, Analyzing, and Manipulating Data With SQL",
                                "Walter Shields","978-83-832-2657-6",true));
    }

    @Override
    public Optional<Book> getById(final int id) {
        return this.books.stream().filter(book -> book.getId() == id).findFirst();
    }

    @Override
    public List<Book> getAll() {
        return this.books;
    }

    @Override
    public void delete(final int id) {
    this.books.removeIf(book -> book.getId() == id);
    }

    @Override
    public void update(Book book) {
        //TODO jak bedzie baza
    }

    @Override
    public List<Book> getByPattern(String pattern) {
        return this.books.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(pattern.toLowerCase()) ||
                        book.getTitle().toLowerCase().contains(pattern.toLowerCase()))
                .toList();
    }
}

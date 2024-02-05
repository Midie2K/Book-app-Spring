package pl.edu.wszib.book.app.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private String isbm;
    private boolean available;

    public Book(String title, String author, String isbm, boolean available){
        this.title = title;
        this.author = author;
        this.isbm = isbm;
        this.available = available;
    }
    public Book(int id){
        this.id = id;
    }
}

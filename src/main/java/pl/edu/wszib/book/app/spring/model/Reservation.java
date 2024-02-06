package pl.edu.wszib.book.app.spring.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;
    private LocalDate dateOfRent;
    private LocalDate endOfRent;
    private LocalDate dateOfReturn;

    public Reservation(int id){
        this.id = id;
    }
}

package pl.edu.wszib.book.app.spring.services;

import pl.edu.wszib.book.app.spring.model.Book;
import pl.edu.wszib.book.app.spring.model.Reservation;

import java.util.List;
import java.util.Map;

public interface IReservationService {
    void persist(int bookId);
    List<Reservation> getAllByID(int id);
    List<Reservation> getAll();
    List<Reservation> getAllRented();
    void bookReturning(int reservationId);
}

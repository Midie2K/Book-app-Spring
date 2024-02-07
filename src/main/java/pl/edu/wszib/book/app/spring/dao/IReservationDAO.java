package pl.edu.wszib.book.app.spring.dao;

import pl.edu.wszib.book.app.spring.model.Reservation;

import java.util.List;
import java.util.Optional;


public interface IReservationDAO {
    Optional<Reservation> getById(int id);
    List<Reservation> getAllByID(int id);
    List<Reservation> getAll();
    List<Reservation> getAllRented();
    List<Reservation> getAllOverdue();
    void persist(Reservation reservation);
    void BookReturning(Reservation reservation);
}

package pl.edu.wszib.book.app.spring.dao;

import pl.edu.wszib.book.app.spring.model.Reservation;

import java.util.List;


public interface IReservationDAO {
    List<Reservation> GetAllByID(int id);
    List<Reservation> GetAll();
    void persist(Reservation reservation);
    void BookReturning(int reservationId);
}

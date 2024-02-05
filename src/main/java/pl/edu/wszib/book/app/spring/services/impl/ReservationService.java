package pl.edu.wszib.book.app.spring.services.impl;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.book.app.spring.dao.IReservationDAO;
import pl.edu.wszib.book.app.spring.model.Book;
import pl.edu.wszib.book.app.spring.model.Reservation;
import pl.edu.wszib.book.app.spring.services.IBookService;
import pl.edu.wszib.book.app.spring.services.IReservationService;
import pl.edu.wszib.book.app.spring.session.SessionObj;

import java.time.LocalDate;

@Service
public class ReservationService implements IReservationService {
    @Autowired
    IReservationDAO reservationDAO;
    @Autowired
    IBookService bookService;
    @Resource
    SessionObj sessionObj;
    @Override
    public void persist(int bookId) {
        Reservation reservation = new Reservation();
        Book book = this.bookService.getById(bookId).get();
        book.setAvailable(false);
        reservation.setBook(book);
        reservation.setUser(this.sessionObj.getLoggedUser());
        reservation.setDateOfRent(LocalDate.now());
        reservation.setDateOfReturn(LocalDate.now().plusWeeks(2));
        reservationDAO.persist(reservation);
    }
}

package pl.edu.wszib.book.app.spring.dao.impl.memory;

import org.springframework.stereotype.Repository;
import pl.edu.wszib.book.app.spring.dao.IReservationDAO;
import pl.edu.wszib.book.app.spring.model.Reservation;

import java.util.List;

@Repository
public class ReservationRepository implements IReservationDAO {
    @Override
    public List<Reservation> GetAllByID(int id) {
        return null;
    }

    @Override
    public List<Reservation> GetAll() {
        return null;
    }

    @Override
    public void NewReservation(int bookId) {

    }

    @Override
    public void BookReturning(int reservationId) {

    }
}

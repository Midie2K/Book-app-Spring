package pl.edu.wszib.book.app.spring.dao.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.book.app.spring.dao.IReservationDAO;
import pl.edu.wszib.book.app.spring.model.Reservation;

import java.util.List;

@Repository
public class ReservationDAO implements IReservationDAO {
    private final String GET_ALL_BY_ID ="FROM pl.edu.wszib.book.app.spring.model.Reservation WHERE id = :id";
    private final String GET_ALL ="FROM pl.edu.wszib.book.app.spring.model.Reservation";

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Reservation> GetAllByID(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Reservation> query = session.createQuery(GET_ALL_BY_ID,Reservation.class);
        query.setParameter("id", id);
        List<Reservation> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public List<Reservation> GetAll() {
        Session session = this.sessionFactory.openSession();
        Query<Reservation> query = session.createQuery(GET_ALL,Reservation.class);
        List<Reservation> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public void persist(Reservation reservation) {
        Session session = this.sessionFactory.openSession();
        reservation.setBook(session.merge(reservation.getBook()));
        try {
            session.beginTransaction();
            session.persist(reservation);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void BookReturning(int reservationId) {
    //TODO
    }
}

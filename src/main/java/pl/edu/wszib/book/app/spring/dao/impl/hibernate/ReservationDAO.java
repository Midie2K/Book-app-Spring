package pl.edu.wszib.book.app.spring.dao.impl.hibernate;

import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.book.app.spring.dao.IReservationDAO;

import pl.edu.wszib.book.app.spring.model.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationDAO implements IReservationDAO {
    private final String GET_BY_ID ="FROM pl.edu.wszib.book.app.spring.model.Reservation WHERE id = :id";
    private final String GET_ALL ="FROM pl.edu.wszib.book.app.spring.model.Reservation";
    private final String GET_ALL_RENTED ="FROM pl.edu.wszib.book.app.spring.model.Reservation WHERE dateOfReturn IS NULL";
    private final String GET_ALL_BY_USER_ID ="FROM pl.edu.wszib.book.app.spring.model.Reservation WHERE user.id = :user_id";
    private final String GET_ALL_OVERDUE = "FROM pl.edu.wszib.book.app.spring.model.Reservation " +
            "WHERE (dateOfReturn IS NULL AND DATEDIFF(endOfRent,current_date ) <= -1) " +
            "OR (dateOfReturn IS NOT NULL AND DATEDIFF(endOfRent, dateOfReturn ) <= -1)";
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Optional<Reservation> getById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Reservation> query = session.createQuery(GET_BY_ID,Reservation.class);
        query.setParameter("id", id);
        try {
            return Optional.of(query.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }finally {
            session.close();
        }
    }

    @Override
    public List<Reservation> getAllByID(int userId) {
        Session session = this.sessionFactory.openSession();
        Query<Reservation> query = session.createQuery(GET_ALL_BY_USER_ID,Reservation.class);
        query.setParameter("user_id", userId);
        List<Reservation> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public List<Reservation> getAll() {
        Session session = this.sessionFactory.openSession();
        Query<Reservation> query = session.createQuery(GET_ALL,Reservation.class);
        List<Reservation> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public List<Reservation> getAllRented() {
        Session session = this.sessionFactory.openSession();
        Query<Reservation> query = session.createQuery(GET_ALL_RENTED,Reservation.class);
        List<Reservation> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public List<Reservation> getAllOverdue() {
        Session session = this.sessionFactory.openSession();
        Query<Reservation> query = session.createQuery(GET_ALL_OVERDUE,Reservation.class);
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
    public void BookReturning(Reservation reservation) {
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.merge(reservation);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }
}

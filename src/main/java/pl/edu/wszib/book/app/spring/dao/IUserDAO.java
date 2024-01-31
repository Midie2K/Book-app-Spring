package pl.edu.wszib.book.app.spring.dao;

import pl.edu.wszib.book.app.spring.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {
    Optional<User> GetById(int id);
    Optional<User> GetByLogin(String login);
    List<User> getAll();
    void persist(User user);

}

package pl.edu.wszib.book.app.spring.services;

import pl.edu.wszib.book.app.spring.model.User;

public interface IUserService {
    void persist(User user);
    boolean userExist(String login);
    void initInDB();
}

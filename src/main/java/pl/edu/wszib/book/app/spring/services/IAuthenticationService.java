package pl.edu.wszib.book.app.spring.services;

public interface IAuthenticationService {
    void login(String login, String passwd);
    void logout();
}

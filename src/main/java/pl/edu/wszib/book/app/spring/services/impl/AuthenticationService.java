package pl.edu.wszib.book.app.spring.services.impl;

import jakarta.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.book.app.spring.dao.IUserDAO;
import pl.edu.wszib.book.app.spring.model.User;
import pl.edu.wszib.book.app.spring.services.IAuthenticationService;
import pl.edu.wszib.book.app.spring.session.SessionObj;

import java.util.Optional;

@Service
public class AuthenticationService implements IAuthenticationService {
    @Autowired
    IUserDAO userDAO;
    @Resource
    SessionObj sessionObj;
    @Override
    public void login(String login, String passwd) {
        Optional<User> userFromDB = this.userDAO.GetByLogin(login);
        if(userFromDB.isPresent() &&
                userFromDB.get().getPassword().equals(DigestUtils.md5Hex(passwd))) {
            this.sessionObj.setLoggedUser(userFromDB.get());
        }
    }

    @Override
    public void logout() {
        this.sessionObj.setLoggedUser(null);
    }
}

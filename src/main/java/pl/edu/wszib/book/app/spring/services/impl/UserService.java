package pl.edu.wszib.book.app.spring.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.book.app.spring.dao.IUserDAO;
import pl.edu.wszib.book.app.spring.model.Roles;
import pl.edu.wszib.book.app.spring.model.User;
import pl.edu.wszib.book.app.spring.services.IUserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserDAO userDAO;
    @Override
    public void persist(User user) {
        if(user.getRole() == null){
            user.setRole(Roles.USER);
        }
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        this.userDAO.persist(user);
    }

    @Override
    public boolean userExist(String login) {
        if(userDAO.getByLogin(login).isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public void initInDB() {
        List<User> users = new ArrayList<>();
        users.add(new User("admin", DigestUtils.md5Hex("admin123"), Roles.ADMIN, "admin", "adminowski"));
        users.add(new User("user", DigestUtils.md5Hex("user123"), Roles.USER, "Janusz", "Kowalski"));

        for(User user : users){
            this.userDAO.persist(user);
        }
    }
}

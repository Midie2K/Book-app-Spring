package pl.edu.wszib.book.app.spring.dao.impl.memory;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.book.app.spring.dao.IUserDAO;
import pl.edu.wszib.book.app.spring.model.Roles;
import pl.edu.wszib.book.app.spring.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserDAO {
    private final List<User> users = new ArrayList<>();

    public UserRepository(){
        users.add(new User(1,"admin", DigestUtils.md5Hex("admin123"), Roles.ADMIN, "admin", "adminowski"));
        users.add(new User(2,"user", DigestUtils.md5Hex("user123"), Roles.USER, "Janusz", "Kowalski"));
    }

    @Override
    public Optional<User> GetById(final int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }

    @Override
    public Optional<User> GetByLogin(final String login) {
        return users.stream().filter(user -> user.getLogin().equals(login)).findFirst();
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void persist(final User user) {
        this.users.stream()
                .map(User :: getId)
                .max(Integer :: compare)
                .ifPresentOrElse(
                        i -> user.setId(i+1),
                        () -> user.setId(1)
                );
        this.users.add(user);
    }
}

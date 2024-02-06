package pl.edu.wszib.book.app.spring.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.wszib.book.app.spring.model.User;

@Component
@SessionScope
public class SessionObj {
    private User loggedUser;

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public boolean isLogged(){
        return loggedUser != null;
    }
    public boolean isAdmin(){
        if (isLogged()){
            if(loggedUser.getRole().name().equals("ADMIN")){
                return true;
            }
        }
        return false;
    }

}

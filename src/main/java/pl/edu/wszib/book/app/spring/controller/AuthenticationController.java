package pl.edu.wszib.book.app.spring.controller;

import jakarta.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.book.app.spring.dao.IUserDAO;
import pl.edu.wszib.book.app.spring.model.User;
import pl.edu.wszib.book.app.spring.session.SessionObj;

import java.util.Optional;

@Controller
public class AuthenticationController {
    @Autowired
    IUserDAO userDAO;
    public static User loggedUser;
    @Resource
    SessionObj sessionObj;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("isLogged",
                this.sessionObj.isLogged());
        //model.addAttribute("logged", null);
        return "login";
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user, Model model){
        Optional<User> userFromDB = this.userDAO.GetByLogin(user.getLogin());
        model.addAttribute("isLogged",
                AuthenticationController.loggedUser != null);

        if(userFromDB.isPresent() &&
                userFromDB.get().getPassword().equals(DigestUtils.md5Hex(user.getPassword()))){

            this.sessionObj.setLoggedUser(userFromDB.get());
            model.addAttribute("logged", true);
            return "redirect:/main";
        }
        else{
            //model.addAttribute("user", new User());
            model.addAttribute("logged",false);
            return "login";
        }

    }
    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(){
        this.sessionObj.setLoggedUser(null);

        return "redirect:/main";
    }
}

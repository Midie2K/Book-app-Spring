package pl.edu.wszib.book.app.spring.controller;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.book.app.spring.services.IBookService;
import pl.edu.wszib.book.app.spring.session.SessionObj;


@Controller
public class CommonController {
    @Autowired
    IBookService bookService;
    @Resource
    SessionObj sessionObj;

    @RequestMapping(path = {"/","/main","/index"}, method = RequestMethod.GET)
    public String main(Model model){
        model.addAttribute("books", this.bookService.getAll());
        model.addAttribute("isLogged",
                this.sessionObj.isLogged());
        return "index";
    }

}

package pl.edu.wszib.book.app.spring.controller;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.book.app.spring.model.Book;
import pl.edu.wszib.book.app.spring.services.IBookService;
import pl.edu.wszib.book.app.spring.services.IReservationService;
import pl.edu.wszib.book.app.spring.session.SessionObj;


@Controller
public class CommonController {
    @Autowired
    IBookService bookService;
    @Autowired
    IReservationService reservationService;
    @Resource
    SessionObj sessionObj;

    @RequestMapping(path = {"/","/main","/index"}, method = RequestMethod.GET)
    public String main(Model model){
        model.addAttribute("books", this.bookService.getAll());
        model.addAttribute("rented", this.reservationService.getAllRented());
        model.addAttribute("isLogged",
                this.sessionObj.isLogged());
        model.addAttribute("isAdmin",
                this.sessionObj.isAdmin());
        return "index";
    }
    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String search(Model model){
        model.addAttribute("books", bookService.getAll());
        model.addAttribute("pattern", "");
        model.addAttribute("isLogged",
                this.sessionObj.isLogged());
        model.addAttribute("isAdmin",
                this.sessionObj.isAdmin());
        return "search";
    }
    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String search(@RequestParam("pattern") String pattern, Model model){
        model.addAttribute("isLogged",
                this.sessionObj.isLogged());
        model.addAttribute("isAdmin",
                this.sessionObj.isAdmin());
        model.addAttribute("books", bookService.getByPattern(pattern));
        return "search";
    }

    @RequestMapping(path = "/addBook", method = RequestMethod.GET)
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("isLogged",
                this.sessionObj.isLogged());
        model.addAttribute("isAdmin",
                this.sessionObj.isAdmin());
        return "addBook";
    }
    @RequestMapping(path = "/addBook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute Book book, Model model){
        model.addAttribute("isLogged",
                this.sessionObj.isLogged());
        model.addAttribute("isAdmin",
                this.sessionObj.isAdmin());
        bookService.persist(book);
        return "redirect:/main";
    }

}

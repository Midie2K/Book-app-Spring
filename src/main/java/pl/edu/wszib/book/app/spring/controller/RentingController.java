package pl.edu.wszib.book.app.spring.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.book.app.spring.dao.IBookDAO;
import pl.edu.wszib.book.app.spring.dao.IReservationDAO;
import pl.edu.wszib.book.app.spring.dao.IUserDAO;
import pl.edu.wszib.book.app.spring.model.Book;
import pl.edu.wszib.book.app.spring.session.SessionObj;

import java.util.Optional;

@Controller 
public class RentingController {
    @Autowired
    IBookDAO bookDAO;
    @Autowired
    IReservationDAO reservationDAO;
    @Resource
    SessionObj sessionObj;

    @RequestMapping(path = "/rent/{bookId}", method = RequestMethod.GET)
    private String renting(@PathVariable final int bookId){
        Optional<Book> book = this.bookDAO.getById(bookId);
        if(book.isPresent()){

        }

        return "redirect:/main";
    }
    
}

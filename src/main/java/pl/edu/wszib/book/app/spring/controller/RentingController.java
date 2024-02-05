package pl.edu.wszib.book.app.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.book.app.spring.services.IReservationService;


@Controller 
public class RentingController {
    @Autowired
    IReservationService reservationService;

    @RequestMapping(path = "/rent/{bookId}", method = RequestMethod.GET)
    private String renting(@PathVariable final int bookId){
        reservationService.persist(bookId);
        return "redirect:/main";
    }
    
}

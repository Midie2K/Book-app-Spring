package pl.edu.wszib.book.app.spring.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.book.app.spring.services.IReservationService;
import pl.edu.wszib.book.app.spring.session.SessionObj;


@Controller 
public class ReservationController {
    @Autowired
    IReservationService reservationService;
    @Resource
    SessionObj sessionObj;

    @RequestMapping(path = "/rent/{bookId}", method = RequestMethod.GET)
    private String renting(@PathVariable final int bookId){
        reservationService.persist(bookId);
        return "redirect:/main";
    }
    @RequestMapping(path = "/history", method = RequestMethod.GET)
    private String history(Model model){
        model.addAttribute("isLogged",
                this.sessionObj.isLogged());
        model.addAttribute("isAdmin",
                this.sessionObj.isAdmin());
        if(this.sessionObj.isAdmin()){
            model.addAttribute("history", reservationService.getAll());
        }else {
            model.addAttribute("history",
                    reservationService.getAllByID(sessionObj.getLoggedUser().getId()));
        }
        return "history";
    }

    @RequestMapping(path = "/return/{reservationId}", method = RequestMethod.GET)
    private String returning(@PathVariable final int reservationId){
        reservationService.bookReturning(reservationId);
        return "redirect:/history";
    }

    @RequestMapping(path = "/history/overdue", method = RequestMethod.GET)
    private String overdoe(Model model){
        model.addAttribute("isLogged",
                this.sessionObj.isLogged());
        model.addAttribute("isAdmin",
                this.sessionObj.isAdmin());
        model.addAttribute("history", reservationService.getAllOverdue());
        return "/history";
    }
    
}

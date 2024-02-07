package pl.edu.wszib.book.app.spring.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.book.app.spring.services.IBookService;
import pl.edu.wszib.book.app.spring.services.IUserService;

@RestController
public class SimpleRestController {
    @Autowired
    IBookService bookService;
    @Autowired
    IUserService userService;

    @RequestMapping(path = "/init/book", method = RequestMethod.GET)
    private String BookInit(){
        this.bookService.initInDB();
        return "redirect:/main";
    }
    @RequestMapping(path = "/init/user", method = RequestMethod.GET)
    private String UserInit(){
        this.userService.initInDB();
        return "redirect:/main";
    }
}
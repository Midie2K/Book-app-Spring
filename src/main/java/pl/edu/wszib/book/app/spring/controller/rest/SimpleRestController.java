package pl.edu.wszib.book.app.spring.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(path = "/book/init", method = RequestMethod.PUT)
    public ResponseEntity<Object> bookInit() {
        this.bookService.initInDB();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(path = "/user/init", method = RequestMethod.PUT)
    public ResponseEntity<Object> userInit() {
        this.userService.initInDB();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

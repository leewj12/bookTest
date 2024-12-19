package kos.mo.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("/book1")
    public String getBook1() {
        return "book1";
    }
}

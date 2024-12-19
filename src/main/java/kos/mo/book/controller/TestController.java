package kos.mo.book.controller;

import kos.mo.book.dto.TestDTO;
import kos.mo.book.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/test")
    public String getTest() {
        testService.getAll();
        return "test";
    }

    @GetMapping("/tpTest")
    public String getTpTest() {
//        testService.getAll();
        return "tpTest/tpTest";
    }

}

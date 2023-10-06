package net.dabbit.skd21.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "book";
    }
}

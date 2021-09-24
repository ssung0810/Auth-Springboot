package com.ssung.Auth.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signup")
    public String signup() {
        return "Signup";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }
}

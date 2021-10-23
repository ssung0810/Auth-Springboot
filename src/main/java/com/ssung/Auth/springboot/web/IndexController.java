package com.ssung.Auth.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/admin/index")
    public String AdminIndex() {
        return "admin/index";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/management/index")
    public String ManagementIndex() {
        return "management/index";
    }

    @GetMapping("/profile/index")
    public String ProfileIndex() {
        return "profile/index";
    }
}

package com.ssung.Auth.springboot.web;

import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
public class IndexApiController {

    @GetMapping("/api/public/test1")
    public String test1() {
        return "API Test 1";
    }

    @GetMapping("/api/public/test2")
    public String test2() {
        return "API Test 2";
    }
}

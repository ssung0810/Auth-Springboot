package com.ssung.Auth.springboot.web;

import com.ssung.Auth.springboot.domain.user.UserRepository;
import com.ssung.Auth.springboot.domain.user.Users;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IndexApiController {

    private final UserRepository userRepository;

    @GetMapping("/api/public/test1")
    public String test1() {
        return "API Test 1";
    }

    @GetMapping("/api/public/test2")
    public String test2() {
        return "API Test 2";
    }

    @GetMapping("/api/public/users")
    public List<Users> allUsers() {
        return this.userRepository.findAll();
    }
}

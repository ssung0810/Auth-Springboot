package com.ssung.Auth.springboot.web;

import com.ssung.Auth.springboot.service.signup.SignupService;
import com.ssung.Auth.springboot.web.dto.SignupSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SignupApiController {

    private final SignupService signupService;

    @PostMapping("/api/signup")
    public Long save(@RequestBody SignupSaveRequestDto signupSaveRequestDto) {
        return signupService.save(signupSaveRequestDto);
    }
}

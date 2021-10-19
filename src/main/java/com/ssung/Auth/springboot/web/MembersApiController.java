package com.ssung.Auth.springboot.web;

import com.ssung.Auth.springboot.service.members.MembersService;
import com.ssung.Auth.springboot.web.dto.MembersSignupRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MembersApiController {

    private final MembersService memberService;

    @PostMapping("/api/s1/member")
    public Long signup(@RequestBody MembersSignupRequestDto requestDto) {
        return memberService.signup(requestDto);
    }
}

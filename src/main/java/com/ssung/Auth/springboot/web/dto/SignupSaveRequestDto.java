package com.ssung.Auth.springboot.web.dto;

import com.ssung.Auth.springboot.domain.Signup.Signup;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupSaveRequestDto {

    private String id;
    private String pw;
    private String email;
    private int phone;

    @Builder
    public SignupSaveRequestDto(String id, String pw, String email, int phone) {
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.phone = phone;
    }

    public Signup toEntity() {
        return Signup.builder()
                .id(id)
                .pw(pw)
                .email(email)
                .phone(phone)
                .build();
    }
}

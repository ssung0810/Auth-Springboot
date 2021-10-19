package com.ssung.Auth.springboot.web.dto;

import com.ssung.Auth.springboot.domain.members.Members;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MembersSignupRequestDto {

    private String nickname;
    private String password;
    private String email;
    private String phone;

    @Builder
    public MembersSignupRequestDto(String nickname, String password, String email, String phone) {
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public Members toEntity() {
        return Members.builder()
                .nickname(nickname)
                .password(password)
                .email(email)
                .phone(phone)
                .build();
    }
}

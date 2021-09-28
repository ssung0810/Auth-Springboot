package com.ssung.Auth.springboot.domain.Signup;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SignupRepositoryTest {

    @Autowired
    SignupRepository signupRepository;

    @After
    public void cleanup() {
        signupRepository.deleteAll();
    }

    @Test
    public void 회원가입_완료하기() {
        // given
        String id = "ssung";
        String pw = "qwer1234";
        String email = "qwer@naver.com";
        String phone = "01011112222";

        signupRepository.save(Signup.builder()
                .id(id)
                .pw(pw)
                .email(email)
                .phone(phone)
                .build());

        // when
        List<Signup> signupList = signupRepository.findAll();

        // then
        Signup signup = signupList.get(0);
        assertThat(signup.getId()).isEqualTo(id);
        assertThat(signup.getPw()).isEqualTo(pw);
        assertThat(signup.getEmail()).isEqualTo(email);
        assertThat(signup.getPhone()).isEqualTo(phone);
    }
}

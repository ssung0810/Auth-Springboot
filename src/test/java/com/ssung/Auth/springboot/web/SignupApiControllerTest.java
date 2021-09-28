package com.ssung.Auth.springboot.web;

import com.ssung.Auth.springboot.domain.Signup.Signup;
import com.ssung.Auth.springboot.domain.Signup.SignupRepository;
import com.ssung.Auth.springboot.web.dto.SignupSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.rmi.server.ExportException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SignupApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private SignupRepository signupRepository;

    @After
    public void tearDown() throws Exception {
        signupRepository.deleteAll();
    }

    @Test
    public void Signup_가입된다() throws Exception {
        // given
        String id = "ssung";
        String pw = "qwer1234";
        String email = "qwer@naver.com";
        String phone = "00011112222";

        SignupSaveRequestDto requestDto = SignupSaveRequestDto.builder()
                .id(id)
                .pw(pw)
                .email(email)
                .phone(phone)
                .build();

        String url = "http://localhost:" + port + "/api/signup";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Signup> all = signupRepository.findAll();
        assertThat(all.get(0).getId()).isEqualTo(id);
        assertThat(all.get(0).getPw()).isEqualTo(pw);
        assertThat(all.get(0).getEmail()).isEqualTo(email);
        assertThat(all.get(0).getPhone()).isEqualTo(phone);
    }
}

package com.ssung.Auth.springboot.web;

import com.ssung.Auth.springboot.domain.members.Members;
import com.ssung.Auth.springboot.domain.members.MembersRepository;
import com.ssung.Auth.springboot.web.dto.MembersSignupRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MembersApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MembersRepository memberRepository;

    @Test
    public void 회원등록_되다() throws Exception {
        // given
        String nickname = "nickname";
        String password = "password";
        String email = "email";
        String phone = "phone";

        MembersSignupRequestDto requestDto = MembersSignupRequestDto.builder()
                .nickname(nickname)
                .password(password)
                .email(email)
                .phone(phone)
                .build();

        String url = "http://localhost:"+port+"/api/s1/member";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Members> memberList = memberRepository.findAll();
        assertThat(memberList.get(0).getNickname()).isEqualTo(nickname);
        assertThat(memberList.get(0).getPassword()).isEqualTo(password);
        assertThat(memberList.get(0).getEmail()).isEqualTo(email);
        assertThat(memberList.get(0).getPhone()).isEqualTo(phone);
    }
}

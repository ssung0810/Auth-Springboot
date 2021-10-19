package com.ssung.Auth.springboot.domain.members;

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
public class MembersRepositoryTest {

    @Autowired
    private MembersRepository memberRepository;

    @After
    public void cleanup() {
        memberRepository.deleteAll();
    }

    @Test
    public void 회원등록저장_되다() {
        // given
        String nickname = "nickname";
        String password = "password";
        String email = "email";
        String phone = "phone";

        Members member = memberRepository.save(Members.builder()
                .nickname(nickname)
                .password(password)
                .email(email)
                .phone(phone)
                .build());

        // when
        List<Members> memberList = memberRepository.findAll();

        // then
        assertThat(memberList.get(0).getNickname()).isEqualTo(nickname);
        assertThat(memberList.get(0).getPassword()).isEqualTo(password);
        assertThat(memberList.get(0).getNickname()).isEqualTo(email);
        assertThat(memberList.get(0).getPhone()).isEqualTo(phone);
    }
}

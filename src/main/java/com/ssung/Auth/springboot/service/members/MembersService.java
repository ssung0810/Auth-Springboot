package com.ssung.Auth.springboot.service.members;

import com.ssung.Auth.springboot.domain.members.MembersRepository;
import com.ssung.Auth.springboot.web.dto.MembersSignupRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MembersService {
    private final MembersRepository memberRepository;

    @Transactional
    public Long signup(MembersSignupRequestDto requestDto) {
        return memberRepository.save(requestDto.toEntity()).getId();
    }
}

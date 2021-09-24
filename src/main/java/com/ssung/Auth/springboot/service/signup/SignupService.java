package com.ssung.Auth.springboot.service.signup;

import com.ssung.Auth.springboot.domain.Signup.SignupRepository;
import com.ssung.Auth.springboot.web.dto.SignupSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignupService {

    private final SignupRepository signupRepository;

    @Transactional
    public Long save(SignupSaveRequestDto signupSaveRequestDto) {
        return signupRepository.save(signupSaveRequestDto.toEntity()).getIdx();
    }
}

package com.ssung.Auth.springboot.config.auth;

import com.ssung.Auth.springboot.domain.user.UserRepository;
import com.ssung.Auth.springboot.domain.user.Users;
import lombok.RequiredArgsConstructor;
import org.h2.engine.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DBInit implements CommandLineRunner {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Delete all
        this.userRepository.deleteAll();

        // create users
        Users ssung = new Users("ssung", passwordEncoder.encode("ssung123"), "USER", "");
        Users admin = new Users("admin", passwordEncoder.encode("admin123"), "ADMIN", "ACCESS_TEST1,ACCESS_TEST2");
        Users manager = new Users("manager", passwordEncoder.encode("manager123"), "MANAGER", "ACCESS_TEST1");

        List<Users> users = Arrays.asList(ssung, admin, manager);

        // save to db
        this.userRepository.saveAll(users);
    }
}

package com.ssung.Auth.springboot.domain.Signup;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Signup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Builder
    public Signup(String id, String pw, String email, String phone) {
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.phone = phone;
    }
}

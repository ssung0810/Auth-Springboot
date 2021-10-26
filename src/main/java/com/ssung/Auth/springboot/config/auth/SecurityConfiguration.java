package com.ssung.Auth.springboot.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserPrincipalDetailService userPrincipalDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("ssung").password(passwordEncoder().encode("ssung1234")).roles("ADMIN")
//                .and()
//                .withUser("ordinary").password(passwordEncoder().encode("ordinary123")).roles("USER");

//        auth
//                .inMemoryAuthentication()
//                    .withUser("admin")
//                    .password(passwordEncoder().encode("admin123"))
//                    .roles("ADMIN").authorities("ACCESS_TEST1", "ACCESS_TEST2")
//                .and()
//                    .withUser("user")
//                    .password(passwordEncoder().encode("user123"))
//                    .roles("USER")
//                .and()
//                    .withUser("manager")
//                    .password(passwordEncoder().encode("manager123"))
//                    .roles("MANAGER").authorities("ACCESS_TEST1");

        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailService);

        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();

        http
            .authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/profile/**").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("api/public/test1").hasAuthority("ACCESS_TEST1")
                .antMatchers("api/public/test2").hasAuthority("ACCESS_TEST2")
                .antMatchers("api/public/users").hasRole("ADMIN")
            .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

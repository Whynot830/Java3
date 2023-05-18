package com.example.pw23.Config;

import com.example.pw23.Services.UserAppService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final UserAppService userAppService;
    private PasswordEncoder encoder;

    SecurityConfig(UserAppService userAppService, PasswordEncoder encoder) {
        this.userAppService = userAppService;
        this.encoder = encoder;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable().cors()
                .disable().authorizeHttpRequests()
                .requestMatchers("/login", "/logout", "/register")
                .permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .and().userDetailsService(userAppService);
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userAppService);
        authenticationProvider.setPasswordEncoder(encoder);
        return authenticationProvider;
    }
}

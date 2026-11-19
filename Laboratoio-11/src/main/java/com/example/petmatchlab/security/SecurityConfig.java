package com.example.petmatchlab.security;

import jakarta.servlet.DispatcherType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .dispatcherTypeMatchers(
                    DispatcherType.FORWARD, DispatcherType.ERROR
                ).permitAll()
                .requestMatchers(
                    "/", "/about", "/login", "/register",
                    "/css/**", "/images/**", "/js/**", "/favicon.ico"
                ).permitAll()
                .requestMatchers("/admin", "/admin/**").hasRole("ADMIN")
                .requestMatchers(
                    HttpMethod.GET,
                    "/pets/new",
                    "/pets/{petId}/edit",
                    "/pets/{petId}/requests/{requestId}/replace"
                ).hasRole("ADMIN")
                .requestMatchers(
                    HttpMethod.POST,
                    "/pets",
                    "/pets/{petId}",
                    "/pets/{petId}/delete",
                    "/pets/{petId}/requests/{requestId}/complete",
                    "/pets/{petId}/requests/{requestId}/cancel",
                    "/pets/{petId}/requests/{requestId}/replace"
                ).hasRole("ADMIN")
                .requestMatchers(
                    HttpMethod.POST, "/pets/{petId}/requests"
                ).hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/pets", true)
                .failureUrl("/login?error")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .permitAll()
            );

        return http.build();
    }
}

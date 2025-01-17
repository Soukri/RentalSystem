package com.rental.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // Επιτρέπει την πρόσβαση στο H2 Console
                        .anyRequest().authenticated() // Απαιτεί αυθεντικοποίηση για τις υπόλοιπες διαδρομές
                )
                .csrf(csrf -> csrf.disable()) // Απενεργοποιεί το CSRF για το H2 Console
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin())); // Επιτρέπει τα IFrames για το H2 Console με ασφαλή προέλευση

        return http.build();
    }
}

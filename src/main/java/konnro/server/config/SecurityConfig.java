package konnro.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .csrf(csrf -> csrf.disable())
        .formLogin(form -> form.disable())
        .httpBasic(Customizer.withDefaults())
        .authorizeHttpRequests(request -> request
          .requestMatchers(HttpMethod.POST, "/api/auth/signup").permitAll()
          .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll())
        .build();
  }
}
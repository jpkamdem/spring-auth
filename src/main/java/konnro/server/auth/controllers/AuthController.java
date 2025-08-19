package konnro.server.auth.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import konnro.server.auth.services.AuthService;
import konnro.server.users.models.User;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/auth", consumes = { "application/json" })
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping("/signup")
  ResponseEntity<?> signup(@Valid @RequestBody User user, HttpServletResponse response) {
    Map<String, String> body = new HashMap<>();
    try {
      User storedUser = authService.store(user);
      if (storedUser == null) {
        body.put("message", "Erreur lors de l'inscription");
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
      }

      String token = authService.token(storedUser.getId(), storedUser.getRole());
      Cookie cookie = new Cookie("token", token);
      cookie.setSecure(true);
      cookie.setHttpOnly(true);
      cookie.setMaxAge(900000);
      response.addCookie(cookie);

      body.put("message", "Utilisateur " + storedUser.getUsername() + " créé & authentifié!");
      return new ResponseEntity<>(body, HttpStatus.OK);
    } catch (Exception e) {
      body.put("error", e.getLocalizedMessage());
      return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
  }
}
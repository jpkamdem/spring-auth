package konnro.server.auth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import konnro.server.types.LoginCredentials;
import konnro.server.users.models.User;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @PostMapping("/signup")
  ResponseEntity<?> signup(@Valid @RequestBody User user) {

  }

  @PostMapping("/login")
  ResponseEntity<?> login(@Valid @RequestBody LoginCredentials payload) {

  }

  @PostMapping("/logout")
  ResponseEntity<?> logout() {

  }
}
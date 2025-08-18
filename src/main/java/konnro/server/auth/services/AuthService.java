package konnro.server.auth.services;

import org.springframework.stereotype.Service;

import konnro.server.config.JWTService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final JWTService jwtService;

  public String getToken() {
    return jwtService.generateToken("john");
  }
}
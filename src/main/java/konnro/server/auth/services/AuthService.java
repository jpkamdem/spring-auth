package konnro.server.auth.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import konnro.server.config.JWTService;
import konnro.server.repositories.UserRepository;
import konnro.server.users.models.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final JWTService jwtService;
  private final UserRepository userRepository;

  public User store(User user) {
    return userRepository.save(user);
  }

  public String token(UUID id, String role) {
    return jwtService.generateToken(id, role);
  }
}
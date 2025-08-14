package konnro.server.types;

import jakarta.validation.constraints.Pattern;

public class LoginCredentials {
  @Pattern(regexp = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+", message = "Email invalide")
  private String email;

  @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$", message = "Mot de passe invalide : ")
  private String password;
}
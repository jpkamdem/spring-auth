package konnro.server.users.models;

import java.security.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import konnro.server.types.Roles;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue
  private UUID id;

  @Pattern(regexp = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+", message = "Email invalide")
  private String email;

  @Pattern(regexp = "^[a-z0-9_-]{3,15}$", message = "Nom d'utilisateur invalide : de 3 à 15 caractères, dont aucun spéciaux")
  private String username;

  @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$", message = "Mot de passe invalide : ")
  private String password;

  @Pattern(regexp = "^0[(6|7)][0-9]{8}$", message = "Numéro de téléphone invalide")
  private String phoneNumber;

  @Enumerated(EnumType.STRING)
  @Column(name = "role")
  private Roles role;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Timestamp updatedAt;
}

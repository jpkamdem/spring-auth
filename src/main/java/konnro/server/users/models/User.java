package konnro.server.users.models;

import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue
  private UUID id;

  @Pattern(regexp = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+", message = "Email invalide")
  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Pattern(regexp = "^[a-z0-9_-]{3,30}$", message = "Nom d'utilisateur invalide : de 3 à 30 caractères, dont aucun spéciaux")
  @Column(name = "username", nullable = false, unique = true)

  private String username;

  @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$", message = "Mot de passe invalide : ")
  @Column(name = "password", nullable = false)
  private String password;

  @Pattern(regexp = "^0[(6|7)][0-9]{8}$", message = "Numéro de téléphone invalide")
  @Column(name = "phone_number", nullable = false, unique = true)
  private String phoneNumber;

  @Column(name = "role", nullable = false, insertable = false)
  private String role;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Timestamp updatedAt;
}

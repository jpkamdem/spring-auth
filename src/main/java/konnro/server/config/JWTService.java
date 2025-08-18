package konnro.server.config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
  @Value("${app.secret}")
  private String baseKey;

  @Value("${app.expiration}")
  private Integer expirationDate;

  private Key getSigningKey() {
    byte[] keyBytes = Decoders.BASE64.decode(baseKey);
    return Keys.hmacShaKeyFor(keyBytes);
  }

  public String generateToken(String username) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("hello", "world!");
    return Jwts.builder()
        .claims(claims)
        .subject(username)
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + expirationDate))
        .signWith(getSigningKey())
        .compact();
  }
}
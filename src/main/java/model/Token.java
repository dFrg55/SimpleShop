package model;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.NonNull;

import java.security.Key;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Token {
    private final String jwtAccessSecret= "SmF2YUpha2FydGFTaGltcGxlU2hvcEphdmFKYWthcnRhU2hpbXBsZVNob3BKYXZhSmFrYXJ0YVNoaW1wbGVTaG9wSmF2YUpha2FydGFTaGltcGxlU2hvcEphdmFKYWthcnRhU2hpbXBsZVNob3BKYXZhSmFrYXJ0YVNoaW1wbGVTaG9wSmF2YUpha2FydGFTaGltcGxlU2hvcEphdmFKYWthcnRhU2hpbXBsZVNob3BKYXZhSmFrYXJ0YVNoaW1wbGVTaG9w";
    @Getter
    private String token;
    private String login;
    private String role;

    public Token(String login, String role) {
        this.login = login;
        this.role = role;
        this.token=generateToken(login,role);
    }
    String generateToken(String user,String role){
        final LocalDateTime now = LocalDateTime.now();
        final Instant accessExpirationInstant = now.plusMinutes(5).atZone(ZoneId.systemDefault()).toInstant();
        final Date accessExpiration = Date.from(accessExpirationInstant);
        return Jwts.builder()
                .setSubject(user)
                .setExpiration(accessExpiration)
                .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtAccessSecret)))
                .claim("roles", role)
                .compact();
    }



}

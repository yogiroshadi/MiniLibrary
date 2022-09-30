package com.technical.utility;

import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtToken {

    private final String SECRET_KEY = "el-psy-kongroo-technical-assesment";
    private final String audience = "TechnicalAssesment";

    public String generateToken(String subject,
                                String username,
                                String role) {
        JwtBuilder builder = Jwts.builder();
        builder = builder.setSubject(subject)
                .claim("username", username)
                .claim("role", role)
                .setIssuer("http://localhost:8080")
                .setAudience(this.audience)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY);

        return builder.compact();
    }

    private Claims getClaims(String token) {

        JwtParser parser = Jwts.parser().setSigningKey(SECRET_KEY);
        Jws<Claims> signatureAndClaims = parser.parseClaimsJws(token);
        Claims claims = signatureAndClaims.getBody();

        return claims;
    }

    public String getUsername(String token) {
        Claims claims = getClaims(token);

        return claims.get("username", String.class);
    }

    public Boolean validateToken(String token, UserDetails userDetails) {

        Claims claims = getClaims(token);
        String user= claims.get("username", String.class);
        String audience = claims.getAudience();

        return (user.equals(userDetails.getUsername()) && this.audience.equals(audience));

    }

}

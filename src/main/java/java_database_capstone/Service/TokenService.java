package java_database_capstone.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenService {

    // Mezon 2: Implements a method to return the signing key using the configured secret.
    @Value("${jwt.secret:defaultSecretKeyForSmartClinicProject2026}")
    private String secret;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    /**
     * Mezon 1: Defines a method to generate a JWT token using the user's email.
     * @param email Foydalanuvchi emaili
     * @return Generatsiya qilingan JWT token
     */
    public String generateToken(String email) {
        long expirationTime = 86400000; // 1 kun (millisekundlarda)

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Tokenni tekshirish uchun qo'shimcha metod (ixtiyoriy, lekin foydali)
    public String getEmailFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}

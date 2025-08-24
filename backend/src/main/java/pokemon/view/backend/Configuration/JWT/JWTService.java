package pokemon.view.backend.Configuration.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JWTService {

    private final SecretKey key;
    private final long ttlMillis;

    public JWTService(@Value("${app.jwt.secret}") String base64Secret,
                      @Value("${app.jwt.ttl-ms:1800000}") long ttlMillis) {
        this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(base64Secret));
        this.ttlMillis = ttlMillis;
    }

    public String generateToken(String username) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .header().type("JWT").and()
                .subject(username)
                .issuer("ExpenseTracker")
                .issuedAt(new Date(now))
                .expiration(new Date(now + ttlMillis))
                .signWith(key, Jwts.SIG.HS256)
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUsername(token);
        return username.equals(userDetails.getUsername()) && !isExpired(token);
    }

    public String getUsername(String token) {
        return parse(token).getPayload().getSubject();
    }

    public Date getExpiration(String token) {
        return parse(token).getPayload().getExpiration();
    }

    private boolean isExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    private Jws<Claims> parse(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .clockSkewSeconds(60) // optional
                .build()
                .parseSignedClaims(token);
    }
}

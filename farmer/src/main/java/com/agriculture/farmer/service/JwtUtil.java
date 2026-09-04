package com.agriculture.farmer.service;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private static final String SECRET = "THE KING OF THE INDIAN OCEAN Sorry for the distanbance";
    private static final long EXPIRATION = 1000 *60 * 2;
    private static final Key secretKey = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public String tokenGener(String usrNam){
        return Jwts.builder().setSubject(usrNam).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION)).signWith(secretKey, SignatureAlgorithm.HS256).compact();
    }

    public String unWrap(String token){
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validation(String token){
      try {
          unWrap(token);
          return true;
      }
      catch (JwtException exception){
          return false;
      }
    }
}

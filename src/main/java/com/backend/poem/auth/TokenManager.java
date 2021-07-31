package com.backend.poem.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenManager {

    Key key= Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public static final int validity=5*60*1000;

    public String generateToken(String username){
        return Jwts.builder()
                        .setSubject(username)
                        .setIssuer(username)
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis()+validity))
                        .signWith(key)
                        .compact();
    }

    public boolean tokenValidate(String token){
        if (getUserFromToken(token)!=null&&isExpired(token)){
            return true;
        }
        return false;
    }

    public boolean isExpired(String token){
        Claims claims= getClaim(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }

    private Claims getClaim(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

    public String getUserFromToken(String token){
        Claims claims=getClaim(token);
        return claims.getSubject();
    }
}

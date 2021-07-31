package com.backend.poem.auth;

import com.backend.poem.iface.IUserService;
import com.backend.poem.model.Login;
import com.backend.poem.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.security.Key;
import java.util.Date;
import java.util.Objects;

@Service
public class TokenManager {

    private final IUserService userService;

    public TokenManager(IUserService userService) {
        this.userService = userService;
    }

    Key key= Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public static final int validity=60*1000*500;

    public String generateToken(Login login) throws AuthenticationException {
        User receivedUser;
        receivedUser = userService.getUserByUsername(login.getUsername());
        if (Objects.nonNull(receivedUser)) {
            return createJwt(receivedUser);
        } else
            throw new AuthenticationException("Token could not stored!");
    }

    public String createJwt(User user){
        JwtBuilder jwtBuilder=Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuer(user.getUsername()).claim("userId",user.getId()).claim("name",user.getName())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+validity))
                .signWith(key);
        return jwtBuilder.compact();
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

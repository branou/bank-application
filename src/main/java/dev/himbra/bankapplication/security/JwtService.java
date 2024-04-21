package dev.himbra.bankapplication.security;

import dev.himbra.bankapplication.entity.Client;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);
    public String generateToken(UserDetails userDetails){
        return Jwts
                .builder().setSubject(userDetails.getUsername())
                .setExpiration(new Date(System.currentTimeMillis()+300000))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String generateJwtToken(Authentication authentication){
        Client userDetails=(Client) authentication.getPrincipal();
        return Jwts
                .builder().setSubject(userDetails.getUsername())
                .setExpiration(new Date(System.currentTimeMillis()+300000))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode("3cfa76ef14937c1c0ea519f8fc057a80fcd04a7420f8e8bcd0a7567c272e007b"));
    }
    public  boolean validateJwtToken(String authtoken){
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(authtoken).getBody();
            return true;

        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT Token : {}",e.getMessage());
        }catch(ExpiredJwtException e){
            logger.error("JWT Token is Expired : {}",e. getMessage());
        }catch(UnsupportedJwtException e){
            logger.error("Unsupported JWT :{}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.error("JWT Payload is Empty: {}", e.getMessage());
        }
        return false;
    }

    public  Claims extractAllClaims(String authtoken){
           return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(authtoken).getBody();}

    public String getUsernameFromJwtToken(String token){
        return extractAllClaims(token).getSubject();
      //  SecurityContextHolder.getContext().
    }

}
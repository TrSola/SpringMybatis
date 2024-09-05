package com.willy.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

/**
 * Utility class for handling JWT creation and parsing.
 */
public class JwtUtils {

    // 靜態密鑰確保生成和解析 JWT 使用相同的密鑰
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /**
     * Generates a JWT token with given claims and expiration time.
     *
     * @param claims      The claims to be added to the JWT payload.
     * @param expiration  The expiration time in milliseconds.
     * @return The generated JWT token as a String.
     */
    public static String generateToken(Map<String, Object> claims, long expiration) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();
    }

    /**
     * Parses a JWT token and returns the claims.
     *
     * @param token  The JWT token to be parsed.
     * @return The claims contained in the JWT token.
     * @throws io.jsonwebtoken.JwtException If the token is invalid or expired.
     */
    public static Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Checks if the token is expired.
     *
     * @param token  The JWT token to be checked.
     * @return True if the token is expired, false otherwise.
     */
    public static boolean isTokenExpired(String token) {
        Claims claims = parseToken(token);
        return claims.getExpiration().before(new Date());
    }
}

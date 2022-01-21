package com.java.admin.utils;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JWTUtils {
    //jwt signature签名的密钥
    private final String secret = "king";
    //jwt的失效时间
    private final long expiration = 1000 * 60 * 60 * 24;

    /**
     * 根据荷载生成jwt token
     *
     * @param claims
     * @return token
     */
    public String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    /**
     * 根据token解析参数
     *
     * @param token
     * @return Claims
     */
    public Claims parseToken(String token) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            System.out.println("解析参数失败!");
            return null;
        }
    }
}

package com.willy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

@SpringBootTest
public class TestJWT {

    // 使用靜態密鑰來確保生成和解析 JWT 使用相同的密鑰
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public void testUuid() {
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString(); // 生成隨機 UUID
            System.out.println(uuid); // 輸出 UUID
        }
    }

    /**
     * 生成 JWT
     */
    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>(); // 創建一個 HashMap 來存儲聲明
        claims.put("id", 1); // 添加 id 聲明
        claims.put("name", "tom"); // 添加姓名聲明

        String jwt = Jwts.builder()
            .signWith(key) // 使用安全密鑰簽名
            .setClaims(claims) // 自定義內容（載荷）
            .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 設置有效期為 1 小時
            .compact();
        
        System.out.println("Generated JWT: " + jwt); // 輸出生成的 JWT

        // 將生成的 JWT 傳遞到解析方法中
        parseJwt(jwt);
    }

    /**
     * 解析 JWT
     */
    public void parseJwt(String jwt) {
        Claims claims = Jwts.parserBuilder() // 創建解析器
            .setSigningKey(key) // 指定簽名密鑰
            .build() // 構建 JWT 解析器
            .parseClaimsJws(jwt) // 解析令牌
            .getBody(); // 獲取主體
        
        System.out.println("Parsed Claims: " + claims); // 輸出聲明
    }
}

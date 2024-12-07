package org.example.qff.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import java.awt.image.Kernel;
import java.util.Date;
import java.util.Map;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/12/7 14:32
 **/
public class JwtUtil {
    private static final String key = "admin";
    /**
     * 创建令牌
     *
     * @param claim
     * @return
     */
    public static String creatJwt(Map<String, Object> claim) {
        return JWT.create().withClaim("claim", claim)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))
                .sign(Algorithm.HMAC256(key));
    }

    /**
     * 解析效验JWT令牌
     *
     * @param token
     * @return
     */
    public static Map<String, Object> parseJwt(String token) {
        return JWT.require(Algorithm.HMAC256(key)).build()
                .verify(token).getClaim("claim")
                .asMap();
    }
}

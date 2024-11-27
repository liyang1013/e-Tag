package com.eTag.back.utils;

import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.JWTValidator;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "4f848367-b85a-453a-b0bb-8d9ef58d348c";
    private static final long EXPIRATION_TIME = 60L * 60L * 1000L;

    private static final JWTSigner signer = JWTSignerUtil.hs256(SECRET_KEY.getBytes());

    public static String generateToken(String username) {

        return JWT.create()
                .setPayload("username", username)
                .setExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .setSigner(signer)
                .sign();
    }

    public static Boolean verifyToken(String token) {
        final JWTSigner signer = JWTSignerUtil.hs256(SECRET_KEY.getBytes());
        try {
            Boolean res = JWTUtil.verify(token, signer);
            JWTValidator.of(token).validateDate(new Date());
            return res;
        } catch (ValidateException e) {
            return false;
        }
    }

    public static String getUsername(String token) {
        JWT jwt = JWTUtil.parseToken(token);
        return jwt.getPayload("username").toString();
    }
}
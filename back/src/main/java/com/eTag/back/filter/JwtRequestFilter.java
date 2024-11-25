package com.eTag.back.filter;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private String secret;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws  ServletException, IOException {
        final String token = request.getHeader("token");

        String username = null;
        JWT jwt = JWT.of(token);
        if (token != null) {
            username = jwt.getPayload("name").toString();
            System.out.println("username:"+ username);
        }

        boolean b = jwt.setKey(secret.getBytes()).verify();

        System.out.println("验证签名结果:"+b);

        boolean a = jwt.setKey(secret.getBytes()).validate(0);

        System.out.println("验证Token:"+a);

        JWTValidator re = JWTValidator.of(token).validateDate(new Date());


        filterChain.doFilter(request, response);
    }
}
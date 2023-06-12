//package com.springboot.SolutionNinjas.security;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.List;
//
//@Component
//public class JwtUtils {
//
//    //client id : http://846299408381-aiusv8bko2kue93bvmprgmbdvv395ou9.apps.googleusercontent.com
//    private static final String SECRET_KEY = "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";
//    private static final long EXPIRATION_TIME = 86400000; // 24 hours
//
//    public String generateJwtToken(String email, String name, List<String> roles) {
//        return Jwts.builder()
//                .setSubject(email)
//                .claim("name", name)
//                .claim("roles", roles)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(new Date().getTime() + EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
//                .compact();
//    }
//}

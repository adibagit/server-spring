//package com.springboot.SolutionNinjas.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class AuthController {
//
//    @Autowired
//    private JwtUtils jwtUtils;
//
//    @PostMapping("/login")
//    public String login(@RequestBody LoginRequest loginRequest) {
//        String idToken = loginRequest.getIdToken();
//        List<String> roles = loginRequest.getRoles();
//
//        // Verify the Google ID token and extract necessary information
//        String email = "tatti";// Extract email from the ID token
//                String name = "guhhh";// Extract name from the ID token
//
//                // Generate JWT token
//                String token = jwtUtils.generateJwtToken(email, name, roles);
//
//        return token;
//    }
//
//}

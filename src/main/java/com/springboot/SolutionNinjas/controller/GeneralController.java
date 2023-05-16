package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.model.User;
import com.springboot.SolutionNinjas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class GeneralController {

    @Autowired
    private UserService userService;
    @GetMapping("/role/{email}")
    public ResponseEntity<String> getRole(@PathVariable String email) {
        System.out.println(email);
        return new ResponseEntity<String>(userService.getRole(email), HttpStatus.OK);
    }

    @GetMapping("/userExist/{email}")
    public ResponseEntity<Boolean> userExist(@PathVariable String email) {
        return new ResponseEntity<Boolean>(userService.userExist(email), HttpStatus.OK);
    }
}

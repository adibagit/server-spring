package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.model.User;
import com.springboot.SolutionNinjas.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200/","https://d2sedfhgvk3bdp.cloudfront.net/"})
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        return new ResponseEntity<User>(userService.getOneUser(id),HttpStatus.OK);
    }

    @DeleteMapping("/users")
    public String deleteUser(@RequestParam int id) {
        userService.deleteUser(id);
        return "User having id : "+id+" has been deleted successfully.";
    }

    @PostMapping("/users")
    public ResponseEntity<User> insertUser(@Valid @RequestBody User user) {
        return new ResponseEntity<User>(userService.insertUser(user),HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user ) {
        user.setUserid(id);
        return new ResponseEntity<User>(userService.updateUser(user),HttpStatus.OK);
    }

    @GetMapping("/userOf/{email}")
    public ResponseEntity<List<User>> getUserByEmail(@PathVariable String email) {
        return new ResponseEntity<List<User>>(userService.getUsersByEmailId(email),HttpStatus.OK);
    }

    @GetMapping("/usersByRole/{role}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable String role) {
        return new ResponseEntity<List<User>>(userService.getUsersByRole(role),HttpStatus.OK);
    }
}

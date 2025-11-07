package com.example.plrepa.controller;

import com.example.plrepa.model.User;
import com.example.plrepa.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // ALLOWS FRONTEND TO ACCESS BACKEND
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

   @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody User user) {
    User u = userRepository.findByEmail(user.getEmail());

    if (u == null) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("User not found");
    }

    if (!u.getPassword().equals(user.getPassword())) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Incorrect password");
    }

    // ✅ Return only necessary safe fields, not everything
    Map<String, Object> response = new HashMap<>();
    response.put("id", u.getId());
    response.put("name", u.getName());
    response.put("email", u.getEmail());

    return ResponseEntity.ok(response);
}

}


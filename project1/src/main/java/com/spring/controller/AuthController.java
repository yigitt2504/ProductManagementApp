package com.spring.controller;

import com.spring.model.User;
import com.spring.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        System.out.println("GET /register");
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        if (userRepository.findByUsername(username) != null) {
            return "redirect:/register?exists";
        }
        User u = new User();
        u.setUsername(username);
        u.setPassword(passwordEncoder.encode(password));
        u.setRole("USER");
        userRepository.save(u);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        System.out.println("GET /login");
        return "login";
    }

}

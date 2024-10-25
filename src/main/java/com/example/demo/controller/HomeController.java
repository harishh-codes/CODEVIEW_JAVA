package com.example.demo.controller;


import org.springframework.stereotype.Controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "home";  // This returns home.html
    }

    @GetMapping("/about")
    public String about() {
        return "about";  // This returns about.html
    }

    @GetMapping("/resources")
    public String resources() {
        return "resources";  // This returns resources.html
    }

    @GetMapping("/topic")
    public String topic() {
        return "topic";  // This returns topic.html
    }

    @GetMapping("/difficulty")
    public String difficulty() {
        return "difficulty";  // This returns difficulty.html
    }

    @GetMapping("/company")
    public String company() {
        return "company";  // This returns company.html
    }

    @Autowired
    private UserService userService;
    

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user, Model model) {
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        User existingUser = userService.findByEmail(user.getEmail());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("email", user.getEmail());
            return "home"; // Redirect to home page with login success
        }
        model.addAttribute("error", "Invalid email or password.");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("username", null);
        return "redirect:/login";
    }

}

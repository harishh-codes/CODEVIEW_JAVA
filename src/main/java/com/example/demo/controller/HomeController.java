package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "home";  // This returns home.html
    }

    @GetMapping("/login")
    public String login() {
        return "login";  // This returns login.html
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";  // This returns signup.html
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

}

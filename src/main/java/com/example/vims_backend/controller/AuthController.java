package com.example.vims_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.vims_backend.entity.User;
import com.example.vims_backend.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired private UserService userService;

    @GetMapping("/")
    public String home() { return "index"; }

    @GetMapping("/registerPage")
    public String registerPage() { return "register"; }

    @GetMapping("/loginPage")
    public String loginPage() { return "login"; }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        if (userService.emailExists(user.getEmail())) {
            model.addAttribute("error", "Email already exists!");
            return "register";
        }
        userService.registerUser(user);
        return "redirect:/loginPage";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        User user = userService.authenticate(email, password);
        if (user == null) {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }

        session.setAttribute("user", user);
        if (user.getRole().toString().equals("OFFICER")) {
            return "redirect:/admin/adminhome";
        } else {
            return "redirect:/user/userhome";
        }    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/loginPage";
    }
}


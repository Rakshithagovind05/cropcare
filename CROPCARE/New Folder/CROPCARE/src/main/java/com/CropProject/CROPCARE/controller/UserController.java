package com.CropProject.CROPCARE.controller;

import com.CropProject.CROPCARE.entity.UserEntity;
import com.CropProject.CROPCARE.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // ✅ Show Login Page
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new UserEntity());
        return "login"; // login.html
    }

    // ✅ Handle Login Logic
    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String password,
                            Model model,
                            HttpSession session) {

        UserEntity user = userService.authenticate(username, password);
        if (user != null) {
            session.setAttribute("loggedInUser", user.getUsername()); // store username
            return "redirect:/services";  // redirect to services after login
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    // ✅ Show Register Page
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register"; // register.html
    }

    // ✅ Handle Registration Logic
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserEntity user, Model model) {
        if (userService.isUserExists(user.getUsername())) {
            model.addAttribute("error", "Username already exists. Try another one!");
            return "register";
        }
        userService.saveUser(user);
        model.addAttribute("success", "Registration successful! Please log in.");
        return "redirect:/login";
    }

    // ✅ Optional: Logout (good practice)
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // clear user session
        return "redirect:/login";
    }
}

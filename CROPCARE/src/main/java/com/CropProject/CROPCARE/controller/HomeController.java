package com.CropProject.CROPCARE.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";  // index.html
    }

    @GetMapping("/details")
    public String details() {
        return "details"; // details.html
    }

    @GetMapping("/services")
    public String services() {
        return "services"; // services.html
    }

    // ✅ Removed /login and /register mappings to avoid conflicts
}

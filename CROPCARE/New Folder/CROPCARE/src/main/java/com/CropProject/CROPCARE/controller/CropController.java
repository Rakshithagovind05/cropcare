package com.CropProject.CROPCARE.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.CropProject.CROPCARE.entity.CropEntity;
import com.CropProject.CROPCARE.services.CropService;

@Controller
public class CropController {

    @Autowired
    private CropService cropService;

    @GetMapping("/home")
    public String showHomePage(Model model) {
        List<CropEntity> crops = cropService.getAllCrops();
        model.addAttribute("crops", crops);
        return "home";
    }
}

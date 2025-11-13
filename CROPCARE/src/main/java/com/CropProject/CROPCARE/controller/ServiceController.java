package com.CropProject.CROPCARE.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
public class ServiceController {

    // Services page
    @GetMapping("/our-services")
    public String servicesPage() {
        return "services";
    }

    // Crops page
    @GetMapping("/crops")
    public String cropDetailsPage() {
        return "crops";
    }

    // Remedies page
    @GetMapping("/solutions")
    public String solutionsPage() {
        return "solutions";
    }

    // Disease page
    @GetMapping("/disease")
    public String diseasePage() {
        return "disease";
    }

    // Upload page GET
    @GetMapping("/upload")
    public String uploadPage() {
        return "upload";
    }

    // Upload page POST
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam("crop") String crop,
                                   Model model,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload!");
            return "redirect:/upload";
        }

        try {
            // Save file locally
            String uploadDir = System.getProperty("user.dir") + "/uploads";
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String filePath = uploadDir + "/" + file.getOriginalFilename();
            file.transferTo(new File(filePath));

            // Disease info based on selected crop
            String diseaseName = "";
            String symptoms = "";
            String remedies = "";

            switch (crop.toLowerCase()) {
                case "tomato":
                    diseaseName = "Early Blight / Late Blight";
                    symptoms = "Dark spots with yellow halos; Water-soaked lesions, white mold under leaves";
                    remedies = "Remove affected leaves; Apply copper-based fungicide; Ensure proper ventilation";
                    break;
                case "rice":
                    diseaseName = "Leaf Blast / Brown Spot";
                    symptoms = "Diamond-shaped lesions on leaves; Brown circular patches on older leaves";
                    remedies = "Use resistant varieties; Balanced fertilizers; Remove infected leaves";
                    break;
                case "maize":
                    diseaseName = "Leaf Blight / Rust";
                    symptoms = "Long grayish streaks; Small reddish-brown pustules on leaves";
                    remedies = "Remove infected leaves; Maintain proper spacing; Avoid excessive humidity";
                    break;
                case "cotton":
                    diseaseName = "Wilt Disease / Bacterial Blight";
                    symptoms = "Sudden drooping of leaves; Angular leaf spots, shedding of squares";
                    remedies = "Remove affected parts; Proper irrigation; Use certified seeds";
                    break;
                case "wheat":
                    diseaseName = "Rust / Smuts";
                    symptoms = "Orange powdery patches; Black fungal spores replacing grains";
                    remedies = "Remove infected plants; Rotate crops; Apply fungicide";
                    break;
                default:
                    diseaseName = "Unknown Crop";
                    symptoms = "No data available";
                    remedies = "Try another crop or check manually";
            }

            model.addAttribute("filename", file.getOriginalFilename());
            model.addAttribute("crop", crop);
            model.addAttribute("diseaseName", diseaseName);
            model.addAttribute("symptoms", symptoms);
            model.addAttribute("remedies", remedies);

            return "result"; // show result page

        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Failed to upload file: " + e.getMessage());
            return "redirect:/upload";
        }
    }
}

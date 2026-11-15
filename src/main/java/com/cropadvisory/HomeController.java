
package com.cropadvisory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    private final CropReportRepository cropReportRepository;

    public HomeController(CropReportRepository cropReportRepository) {
        this.cropReportRepository = cropReportRepository;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/upload")
    public String uploadImage(
            @RequestParam("image") MultipartFile image,
            RedirectAttributes redirectAttributes) {

        if (image.isEmpty()) {
            redirectAttributes.addFlashAttribute(
                "message", "Please select an image!");
            return "redirect:/";
        }

        if (image.getContentType() == null ||
                !image.getContentType().startsWith("image/")) {
            redirectAttributes.addFlashAttribute(
                "message", "Please upload a valid image!");
            return "redirect:/";
        }

        try {
            Path uploadPath = Paths.get("uploads");
            Files.createDirectories(uploadPath);

            String originalName = Paths.get(image.getOriginalFilename())
                    .getFileName().toString();

            String extension = originalName.contains(".")
                    ? originalName.substring(originalName.lastIndexOf("."))
                    : "";

            String fileName = UUID.randomUUID() + extension;

            Path filePath = uploadPath.resolve(fileName);
            Files.copy(image.getInputStream(), filePath);

            CropReport report = new CropReport(
                fileName, LocalDateTime.now());

            cropReportRepository.save(report);

            redirectAttributes.addFlashAttribute(
                "message", "Image uploaded and report saved successfully!");

        } catch (IOException e) {
            redirectAttributes.addFlashAttribute(
                "message", "Image upload failed!");
        }

        return "redirect:/";
    }
}

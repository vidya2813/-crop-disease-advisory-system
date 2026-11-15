package com.cropadvisory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CropReportController {

    private final CropReportRepository repository;

    public CropReportController(CropReportRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/reports")
    public String reports(Model model) {
        model.addAttribute("reports", repository.findAll());
        return "reports";
    }
}

package com.example.aicodeanalyzer.controller;

import com.example.aicodeanalyzer.service.AnalysisService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class codeController {
    private final AnalysisService service;

    public codeController(AnalysisService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @PostMapping("/analyze")
    public String analyze(
            @RequestParam("code") String code,
            Model model) {

        try {
            String result = service.getResponse(code);

            model.addAttribute("code", code);
            model.addAttribute("result", result);

        } catch (Exception e) {
            model.addAttribute("code", code);
            model.addAttribute("result",
                    "Error while analyzing code: " + e.getMessage());
        }

        return "index";
    }
}

package com.example.aicodeanalyzer.controller;

import com.example.aicodeanalyzer.service.AnalysisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class codeController {
    private final AnalysisService service;

    public codeController(AnalysisService service) {
        this.service = service;
    }

    @GetMapping("/analyze")
    public String analyze(@RequestBody String file) throws IOException {
        return service.getResponse(file);

    }
}

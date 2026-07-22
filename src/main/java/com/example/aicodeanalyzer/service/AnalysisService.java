package com.example.aicodeanalyzer.service;

import com.example.aicodeanalyzer.ai.OllamaService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Service
public class AnalysisService {
    private final OllamaService Aiservice;
    private final promptService service;

    public AnalysisService(OllamaService service, promptService service1) {
        this.Aiservice = service;
        this.service = service1;
    }

    public String getResponse(String file) throws IOException {
        String prompt=service.getPrompt(file);
        return Aiservice.response(prompt);
    }
}

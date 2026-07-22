package com.example.aicodeanalyzer.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class OllamaService {
    private final ChatClient chatClient;

    public OllamaService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }
    public String response(String prompt){
        return chatClient.prompt().user(prompt).call().content();
    }
}

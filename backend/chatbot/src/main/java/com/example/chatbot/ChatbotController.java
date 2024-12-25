package com.example.chatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ChatbotController {

    @Autowired
    private ChatbotService chatbotService;

    // POST method to handle chatbot conversation
    @PostMapping("/chatbot")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Map<String, String>> getBotResponse(@RequestBody Map<String, String> userInput) {
        String userMessage = userInput.get("userInput");
        String botResponse = generateBotResponse(userMessage);

        // Log user input and bot response
        System.out.println("User Message: " + userMessage);
        System.out.println("Bot Response: " + botResponse);

        Map<String, String> response = new HashMap<>();
        response.put("botResponse", botResponse);
        return ResponseEntity.ok(response);
    }

    // Method to generate a bot response
    private String generateBotResponse(String userMessage) {
        if (userMessage.equalsIgnoreCase("hello")) {
            return "Hello! How can I assist you?";
        } else if (userMessage.equalsIgnoreCase("hanuman")) {
            return "I am the mighty Hanuman, at your service!";
        } else {
            return "Sorry, I don't understand that message.";
        }
    }
}

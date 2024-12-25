package com.example.chatbot;

import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    public String getResponse(String userInput){

        return "You said: " + userInput;
    }
}

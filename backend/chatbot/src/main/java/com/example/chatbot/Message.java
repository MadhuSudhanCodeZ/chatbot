package com.example.chatbot;

public class Message {
    private String userInput;

    public Message() {}

    // Constructor for response
    public Message(String userInput) {
        this.userInput = userInput;
    }

    // Getter and Setter
    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
}

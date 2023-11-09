package com.application.model;


public class ChatMessage {
    private MessageType type;
    private String sender;

    private ChatMessage() {
        // Private constructor to prevent direct instantiation
    }

    public static ChatMessageBuilder builder() {
        return new ChatMessageBuilder();
    }

    public MessageType getType() {
        return type;
    }

    public String getSender() {
        return sender;
    }

    // Other getters for any additional fields

    public static class ChatMessageBuilder {
        private MessageType type;
        private String sender;

        private ChatMessageBuilder() {
            // Private constructor to force the use of the builder() method
        }

        public ChatMessageBuilder type(MessageType type) {
            this.type = type;
            return this;
        }

        public ChatMessageBuilder sender(String sender) {
            this.sender = sender;
            return this;
        }

        // Other builder methods for additional fields, if needed

        public ChatMessage build() {
            ChatMessage message = new ChatMessage();
            message.type = this.type;
            message.sender = this.sender;
            // Set other fields here
            return message;
        }
    }
}

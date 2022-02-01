package com.anotherworld.elbrium;

import java.util.Date;

public class Message { // Класс-конструктор для MainActivity
    private String textMessage;
    private String author;
    private long messageTime;
    private String email;
    public Message(String textMessage, String author, String email) {
        this.textMessage = textMessage;
        this.email = email;
        this.author = author;
        messageTime = new Date().getTime();
    }
    public Message() {}
    public String getTextMessage() {
        return textMessage;
    }
    public String getEmail(){
        return email;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public long getMessageTime() {
        return messageTime;
    }
    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
    public void setEmail(String email){
        this.email = email;
    }
}

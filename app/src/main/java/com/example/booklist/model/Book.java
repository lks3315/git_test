package com.example.booklist.model;

import java.io.Serializable;

public class Book implements Serializable{
    private String subject;
    private String writer;
    private String publisher;
    private String stroy;
    private int image;

    public Book(String subject, String writer, String publisher, String story, int image) {
        this.subject = subject;
        this.writer = writer;
        this.publisher = publisher;
        this.stroy = story;
        this.image = image;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getStroy() {
        return stroy;
    }

    public void setStroy(String stroy) {
        this.stroy = stroy;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

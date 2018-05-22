package com.example.demo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class News {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    private LocalDateTime publishDate;
    private String text;
    private String keywords;

    public News() {
    }

    public News(String title, LocalDateTime publishDate, String text, String keywords) {
        this.title = title;
        this.publishDate = publishDate;
        this.text = text;
        this.keywords = keywords;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}

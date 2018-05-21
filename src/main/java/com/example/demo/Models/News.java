package com.example.demo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class News {

    @Id
    @GeneratedValue
    public Long id;

    public String title;
    public LocalDateTime publishDate;
    public String text;
    public String keywords;
}

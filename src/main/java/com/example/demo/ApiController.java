package com.example.demo;

import com.example.demo.Models.News;
import com.example.demo.Models.Visit;
import com.example.demo.NewsRepository;
import com.example.demo.VisitsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final VisitsRepository visitsRepository;
    private final NewsRepository newsRepository;

    public ApiController(VisitsRepository visitsRepository, NewsRepository newsRepository) {
        this.visitsRepository = visitsRepository;
        this.newsRepository = newsRepository;
    }

    @GetMapping("/visits")
    public Iterable<Visit> getVisits() {
        return visitsRepository.findAll();
    }

    @GetMapping("/news")
    public Iterable<News> getNews(){
        return newsRepository.findAll();
    }
}

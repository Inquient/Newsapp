package com.example.demo;

import com.example.demo.Models.News;
import com.example.demo.Models.User;
import com.example.demo.Models.Visit;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasAuthority('ADMIN')")
public class ApiController {

    private final VisitsRepository visitsRepository;
    private final NewsRepository newsRepository;
    private final UserRepository userRepository;

    public ApiController(VisitsRepository visitsRepository, NewsRepository newsRepository, UserRepository userRepository) {
        this.visitsRepository = visitsRepository;
        this.newsRepository = newsRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/visits")
    public Iterable<Visit> getVisits() {
        return visitsRepository.findAll();
    }

    @GetMapping("/news")
    public Iterable<News> getNews(){
        return newsRepository.findAll();
    }

    @GetMapping("/users")
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }
}

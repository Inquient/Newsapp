package com.example.demo;

import com.example.demo.Models.Visit;
import com.example.demo.VisitsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    private final VisitsRepository visitsRepository;

    public IndexController(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }

    @GetMapping("/")
    public ModelAndView index(Map<String, Object> model) {
        Visit visit = new Visit();
        visit.description = String.format("Visited at %s", LocalDateTime.now());
        visitsRepository.save(visit);

        return new ModelAndView("index", model);
    }
}

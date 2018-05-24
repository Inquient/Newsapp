package com.example.demo;

import com.example.demo.Models.News;
import com.example.demo.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @RequestMapping(value = "/news/{title}")
    public ModelAndView getTitle(
            @RequestParam(name="title", required = false) String title, Map <String, Object> model
    ){
        model.put("title", title);
        return new ModelAndView("title", model);
    }

    @GetMapping("/news")
    public ModelAndView news(Map<String, Object> model){
        Iterable<News> allNews = newsRepository.findAll();
        model.put("news", allNews);
        return new ModelAndView("news", model);
    }

    @RequestMapping(value = "/addNews", method = RequestMethod.GET)
    public ModelAndView addNewNews(){
        return new ModelAndView("addNews");
    }

    @RequestMapping(value = "/news", method = RequestMethod.POST)
    public ModelAndView addNewTitle(
            @AuthenticationPrincipal User user,
            @RequestParam(value="title") String title,
            @RequestParam(value="text") String text,
            Map<String, Object> model) throws IOException {
        News news = new News();
        news.setTitle(title);
        news.setPublishDate(LocalDateTime.now());
        news.setText(text);

        String python = "C:/ProgramData/Anaconda3/python.exe";
        String script = new File("src/main/python/LSA.py").getAbsolutePath();
//        Process p = new ProcessBuilder(python, script, "-t", text).start();
//        BufferedReader lineReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        news.keywords = lineReader.readLine();
        news.setKeywords(script);
        news.setAuthor(user);
        newsRepository.save(news);

        Iterable<News> allNews = newsRepository.findAll();
        model.put("news", allNews);

        return new ModelAndView("news", model);
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        List<News> news = newsRepository.findByTitle(filter);
        model.put("news", news);
        return "news";
    }
}

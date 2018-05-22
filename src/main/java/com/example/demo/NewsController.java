package com.example.demo;

import com.example.demo.Models.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Controller
public class NewsController {

    private final NewsRepository newsRepository;

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
    public ModelAndView news(){
        Map<String, String> model = new HashMap<>();
        return new ModelAndView("news", model);
    }

    @RequestMapping(value = "/addNews", method = RequestMethod.GET)
    public ModelAndView addNewNews(){
        return new ModelAndView("addNews");
    }

    @RequestMapping(value = "/news", method = RequestMethod.POST)
    public ModelAndView addNewTitle(@RequestParam(value="title") String title, @RequestParam(value="text") String text) throws IOException {
        News news = new News();
        news.title = title;
        news.publishDate = LocalDateTime.now();
        news.text = text;

        String python = "C:/ProgramData/Anaconda3/python.exe";
        String script = new File("src/main/python/LSA.py").getAbsolutePath();
//        Process p = new ProcessBuilder(python, script, "-t", text).start();
//        BufferedReader lineReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        news.keywords = lineReader.readLine();
        news.keywords = script;
        newsRepository.save(news);

        return new ModelAndView("news");
    }
}

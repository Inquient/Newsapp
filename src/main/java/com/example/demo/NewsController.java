package com.example.demo;

import com.example.demo.Models.News;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
public class NewsController {

    private final NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @GetMapping("/news")
    public ModelAndView news(){
        Map<String, String> model = new HashMap<>();

//        model.put("title", "Британские парламентарии призвали ужесточить санкции против России");
//        model.put("publishDate", String.valueOf(LocalDateTime.now()));
//        model.put("text", "Комитет по международным делам Палаты общин британского парламента подготовил");
//        model.put("keywords", "политика, санкции, Путин, Великобритания");

//        News news = new News();
//        news.title = "Британские парламентарии призвали ужесточить санкции против России";
//        news.publishDate = LocalDateTime.now();
//        news.text = "Комитет по международным делам Палаты общин британского парламента подготовил";
//        news.keywords = "политика, санкции, Путин, Великобритания";
//        newsRepository.save(news);

        return new ModelAndView("news", model);
    }

    @RequestMapping(value = "/addNews", method = RequestMethod.GET)
    public ModelAndView addNewNews(){
        return new ModelAndView("addNews");
    }

    @RequestMapping(value = "/addTitle", method = RequestMethod.POST)
    public ModelAndView addNewTitle(@RequestParam(value="title") String title, @RequestParam(value="text") String text){
        News news = new News();
        news.title = title;
        news.publishDate = LocalDateTime.now();
        news.text = text;
        news.keywords = "много слов";
        newsRepository.save(news);

        return new ModelAndView("news");
    }
}

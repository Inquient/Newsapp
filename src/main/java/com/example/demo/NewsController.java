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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Map;


@Controller
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @PostMapping("/news/{news}")
    public String removeNews(@RequestParam(name="newsId") News news){
        newsRepository.delete(news);
        return "redirect:/news";
    }

    @GetMapping("/news")
    public String news(@RequestParam(required = false, defaultValue = "") String filter,  Model model){
        Iterable<News> news = newsRepository.findAll();

        if (filter != null && !filter.isEmpty()) {
            news = newsRepository.findByKeywords(filter);
        } else {
            news = newsRepository.findAll();
        }

        model.addAttribute("news", news);
        model.addAttribute("filter", filter);

        return "news";
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
            Map<String, Object> model) throws IOException, InterruptedException {
        News news = new News();
        news.setTitle(title);
        news.setPublishDate(LocalDateTime.now());
        news.setText(text);

        String python = "C:/ProgramData/Anaconda3/python.exe";
        String script = new File("src/main/python/LSA.py").getAbsolutePath();

        ProcessBuilder procBuilder = new ProcessBuilder(python, script,"-t", text);
        procBuilder.redirectErrorStream(true);
        Process process = procBuilder.start();

        InputStream stdout = process.getInputStream();
        InputStreamReader isrStdout = new InputStreamReader(stdout);
        BufferedReader brStdout = new BufferedReader(isrStdout);

        String line = null;
        while((line = brStdout.readLine()) != null) {
            System.out.println(line);
            news.setKeywords(line);
        }
        int exitVal = process.waitFor();

        news.setAuthor(user);
        newsRepository.save(news);

        Iterable<News> allNews = newsRepository.findAll();
        model.put("news", allNews);

        return new ModelAndView("news", model);
    }

}

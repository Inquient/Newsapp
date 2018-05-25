package com.example.demo;

import com.example.demo.Models.News;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface NewsRepository extends CrudRepository<News, Long>{

    List<News> findByTitle(String title);

    List<News> findByKeywords(String keywords);

}

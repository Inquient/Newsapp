package com.example.demo;

import com.example.demo.Models.News;
import org.springframework.data.repository.CrudRepository;

interface NewsRepository extends CrudRepository<News, Long>{
}

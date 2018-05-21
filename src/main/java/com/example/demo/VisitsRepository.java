package com.example.demo;

import com.example.demo.Models.Visit;
import org.springframework.data.repository.CrudRepository;

interface VisitsRepository extends CrudRepository<Visit, Long> {
}

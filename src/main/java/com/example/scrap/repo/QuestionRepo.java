package com.example.scrap.repo;

import com.example.scrap.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, String> {
}

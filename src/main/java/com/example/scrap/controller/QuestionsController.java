package com.example.scrap.controller;

import com.example.scrap.DTO.QuestionDTO;
import com.example.scrap.model.Category;
import com.example.scrap.model.Question;
import com.example.scrap.repo.CategoryRepo;
import com.example.scrap.repo.QuestionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class QuestionsController {
    private final QuestionRepo questionRepo;
    private final CategoryRepo categoryRepo;

    @GetMapping("/question/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable String id){
        Question question = questionRepo.findById(id).orElseThrow();
//        model.addAttribute("Question", question);
//        model.addAttribute("Categories", categoryRepo.findAll());
        return ResponseEntity.ok(question);
    }

    @GetMapping("/question")
    public ResponseEntity<Category> sample(){
//        Question question = questionRepo.findById(id).orElseThrow();
//        model.addAttribute("Question", question);
//        model.addAttribute("Categories", categoryRepo.findAll());
        return ResponseEntity.ok(new Category());
    }

    @PostMapping("/question")
    public ResponseEntity<String> setQuestion(@RequestBody QuestionDTO questionResponse){
        Question question = new Question();
        question.setQuestion(questionResponse.getQuestion());
        Set<Category> categorySet = new HashSet<>();
        for (String category: questionResponse.getCategories()){
            Category category1 = categoryRepo.findByCategoryName(category);
            categorySet.add(category1);
        }
        question.setCategories(categorySet);
        question.setOptions(questionResponse.getOptions());


        questionRepo.save(question);
//        model.addAttribute("question", question);
        return ResponseEntity.ok("Question Added");
    }

    @PutMapping("/question/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable String id, @RequestBody QuestionDTO questionResponse){
        Question question = questionRepo.findById(id).orElseThrow();
        question.setQuestion(questionResponse.getQuestion());
        Set<Category> categorySet = new HashSet<>();
        for (String category: questionResponse.getCategories()){
            Category category1 = categoryRepo.findByCategoryName(category);
            categorySet.add(category1);
        }
        question.setCategories(categorySet);
        question.setOptions(questionResponse.getOptions());
        questionRepo.save(question);
//        model.addAttribute("question", question);
        return ResponseEntity.ok("Question Updated");
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable String id){
        Category category = categoryRepo.findById(id).orElseThrow();
//        model.addAttribute("Question", question);
//        model.addAttribute("Categories", categoryRepo.findAll());
        return ResponseEntity.ok(category);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable String id, @RequestBody Category categoryResponse){
        Category category = categoryRepo.findById(id).orElseThrow();
        category.setCategoryName(categoryResponse.getCategoryName());
//        model.addAttribute("question", question);
        categoryRepo.save(category);
        return ResponseEntity.ok("Category Updated");
    }

    @PostMapping("/category")
    public ResponseEntity<String> setCategory( @RequestBody Category categoryResponse){
        Category category = new Category();
        category.setCategoryName(categoryResponse.getCategoryName());
//        model.addAttribute("question", question);
        categoryRepo.save(category);
        System.out.println("category = " + category);
        return ResponseEntity.ok("Category Updated");
    }

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> questions(){
        return ResponseEntity.ok(questionRepo.findAll());
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> categories(){
        return ResponseEntity.ok(categoryRepo.findAll());
    }

}

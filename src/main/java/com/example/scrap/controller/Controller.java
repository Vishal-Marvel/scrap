package com.example.scrap.controller;

import com.example.scrap.model.Question;
import com.example.scrap.repo.QuestionRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class Controller {
    private final QuestionRepo questionRepo;
    @PostMapping("/data")

    public ResponseEntity<String> request(@RequestBody String dataClass) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<Integer, String> keys = objectMapper.readValue(dataClass, new TypeReference<HashMap<Integer, String>>() {});
//        Map<String, String> keyAnswers = dataClass.getKeyAnswers();
//        System.out.println("keyAnswers = " + keyAnswers);
//        System.out.println("dataClass = " + keys.get(1));
        return ResponseEntity.ok("Data Received");
    }

    @GetMapping("/data")
    public ResponseEntity<List<Question>> sendData() {
        List<Question> questions = questionRepo.findAll();
        // Add more data as needed

        // Send the data as the response
        return ResponseEntity.ok(questions  );
    }


}

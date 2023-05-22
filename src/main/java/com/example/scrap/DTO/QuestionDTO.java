package com.example.scrap.DTO;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDTO {
    private String question;
    private List<String> options;
    private List<String> categories;


}

package com.example.scrap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Student {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String number;
    private String mailID;

}

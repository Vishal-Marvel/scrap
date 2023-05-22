package com.example.scrap.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Security;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Category {
    @Id
    private String id = UUID.randomUUID().toString();
    @Column(unique = true)
    private String categoryName;

}

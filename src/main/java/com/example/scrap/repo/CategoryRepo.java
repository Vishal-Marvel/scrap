package com.example.scrap.repo;

import com.example.scrap.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, String> {
    Category findByCategoryName(String name);
}

package com.jang.healthdaily.repository.Category;


import com.jang.healthdaily.model.Category.Category;
import com.jang.healthdaily.model.Category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAll();
    Category findById(long categoryId);
}
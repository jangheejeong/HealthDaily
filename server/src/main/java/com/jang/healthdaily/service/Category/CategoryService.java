package com.jang.healthdaily.service.Category;

import com.jang.healthdaily.model.Category.Category;
import com.jang.healthdaily.payload.Category.CategoryRequest;
import com.jang.healthdaily.repository.Camp.CampRepository;
import com.jang.healthdaily.repository.Category.CategoryRepository;
import com.jang.healthdaily.model.Category.Category;
import com.jang.healthdaily.payload.Category.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    /*@Autowired
    CategoryMappingRepository categoryMappingRepository;*/

    @Autowired
    CampRepository campRepository;


    public void addCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        categoryRepository.save(category);
    }

    /*public void addCategoryToSite(CategoryToCampsiteRequest categoryMappingRequest, String campsiteCode) {
        Campsite campsite = campRepository.findByCompanyCode(campsiteCode).get(0);
        CategoryMapping categoryMapping = new CategoryMapping(
            categoryMappingRequest.getCategoryId(),
            campsite.getId()
        );

        categoryMappingRepository.save(categoryMapping);
    }*/

    public List<Category> getCategoryList() {
        List<Category> result = categoryRepository.findAll();
        return result;
    }

}
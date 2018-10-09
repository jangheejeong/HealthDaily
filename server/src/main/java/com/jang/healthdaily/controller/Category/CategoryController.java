package com.jang.healthdaily.controller.Category;

import com.jang.healthdaily.payload.ApiResponse;
import com.jang.healthdaily.payload.Category.CategoryRequest;
import com.jang.healthdaily.service.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 캠핑 컨트롤러
 * */
@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        categoryService.addCategory(categoryRequest);

        return ResponseEntity.ok(new ApiResponse(true, "category added successfully"));
    }

    /*@PostMapping("/user/category")
    public ResponseEntity<?> addCategoryToSite(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody CategoryToCampsiteRequest categoryToCampsiteRequest) {
        String companyCode = currentUser.getCompanyCode();
        categoryService.addCategoryToSite(categoryToCampsiteRequest, companyCode);

        return ResponseEntity.ok(new ApiResponse(true, "category added to campsite successfully"));
    }*/

    @GetMapping("/category")
    public ResponseEntity<?> getCategoryList() {
        return ResponseEntity.ok(categoryService.getCategoryList());
    }
}



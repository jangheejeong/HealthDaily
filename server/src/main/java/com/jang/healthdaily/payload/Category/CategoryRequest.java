package com.jang.healthdaily.payload.Category;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoryRequest {
    @NotBlank
    private String name;
}

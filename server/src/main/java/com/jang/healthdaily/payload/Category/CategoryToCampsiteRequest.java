package com.jang.healthdaily.payload.Category;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoryToCampsiteRequest {
    @NotNull
    private long categoryId;
}

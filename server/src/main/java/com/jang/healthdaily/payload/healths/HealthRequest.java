package com.jang.healthdaily.payload.healths;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class HealthRequest {
    @NotBlank
    private String name;

    @NotNull
    private Boolean isAnaerobic;
}

package com.jang.healthdaily.payload.Facilities;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FacilitiesRequest {
    @NotBlank
    private String name;
}

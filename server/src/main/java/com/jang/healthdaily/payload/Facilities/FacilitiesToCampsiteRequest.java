package com.jang.healthdaily.payload.Facilities;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FacilitiesToCampsiteRequest {
    @NotNull
    private long facilitiesId;
}

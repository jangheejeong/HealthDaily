package com.jang.healthdaily.payload.Camp;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SiteInfo {
    // 객실정보
    @NotBlank
    @Size(max = 45)
    private String name;

    // 객실 허용인원
    private int allowedPeople;

    // 객실 수
    @NotNull
    private int siteCount;

    // 카테고리 id
    @NotNull
    private int categoryId;
}

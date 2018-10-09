package com.jang.healthdaily.payload.Camp;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PriceInfo {
    // 객실정보
    @NotBlank
    @Size(max = 45)
    private String name;


    // 가격정보
    @NotNull
    private int weekdayDefaultPrice; //평일 기본
    @NotNull
    private int weekendDefaultPrice; //주말 기본

    private int weekdaySeasonPrice; // 평일 성수기
    private int weekendSeasonPrice; // 주말 성수기

    private int weekdayHigherSeasonPrice; // 평일 극성수기
    private int weekendHigherSeasonPrice; // 주말 극성수기

}

package com.jang.healthdaily.payload.Camp;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
public class SiteRequest {
    // 운영정보
    @NotBlank
    @Size(max = 10)
    private String startDate;

    @NotBlank
    @Size(max = 10)
    private String endDate;

    // 운영유형 사용함/사용안함
    private boolean seasonUsed;

    // 부대시설 id
    @NotNull
    private ArrayList<Integer> facilitiesList;

    // 대표이미지, 서브이미지
    private String image;
    private String subImage1;
    private String subImage2;
    private String subImage3;

    @NotNull
    private long categoryId;

    @NotNull
    private ArrayList<PriceInfo> priceInfos;

    @NotNull
    private ArrayList<SiteInfo> siteInfos;
}
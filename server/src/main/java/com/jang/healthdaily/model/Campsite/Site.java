package com.jang.healthdaily.model.Campsite;

import com.jang.healthdaily.model.audit.DateAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "site")
@Data
public class Site extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="campsite_id")
    private long campsiteId;

    @Column(name="category_id")
    private long categoryId;

    @NotBlank
    @Size(max = 45)
    private String name;

    @NotBlank
    @Size(max = 20)
    private String barcode;

    @NotNull
    private int weekdayDefaultPrice; //평일 기본
    @NotNull
    private int weekendDefaultPrice; //주말 기본

    private int weekdaySeasonPrice; // 평일 성수기
    private int weekendSeasonPrice; // 주말 성수기

    private int weekdayHigherSeasonPrice; // 평일 극성수기
    private int weekendHigherSeasonPrice; // 주말 극성수기

    private int allowedPeople;

    @NotNull
    private int siteCount;

    /*@ManyToMany
    @JoinTable(name="site_category",
            joinColumns = @JoinColumn(name = "site_no"),
            inverseJoinColumns = @JoinColumn(name = "category_no"))*/

//    private List<Category> categories = new ArrayList<Category>();


    public Site(String name, String barcode, long campsiteId, int allowedPeople,
                int weekdayDefaultPrice, int weekendDefaultPrice,
                int weekdaySeasonPrice, int weekendSeasonPrice,
                int weekdayHigherSeasonPrice,
                int weekendHigherSeasonPrice, int siteCount, int categoryId) {
        this.name = name;
        this.barcode = barcode;
        this.campsiteId = campsiteId;
        this.allowedPeople = allowedPeople;
        this.weekdayDefaultPrice = weekdayDefaultPrice;
        this.weekendDefaultPrice = weekendDefaultPrice;
        this.weekdaySeasonPrice = weekdaySeasonPrice;
        this.weekendSeasonPrice = weekendSeasonPrice;
        this.weekdayHigherSeasonPrice = weekdayHigherSeasonPrice;
        this.weekendHigherSeasonPrice = weekendHigherSeasonPrice;
        this.siteCount = siteCount;
        this.categoryId = categoryId;
    }

    /*public boolean addCategory(Category category) {
        if(categories == null)
            categories = new ArrayList<>();

        return categories.add(category);
    }*/
}

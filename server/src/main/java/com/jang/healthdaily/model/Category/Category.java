package com.jang.healthdaily.model.Category;


import com.jang.healthdaily.model.audit.DateAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "category")
@Data
public class Category extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    public Category() {

    }
}
package com.jang.healthdaily.model.Facilities;

import com.jang.healthdaily.model.audit.DateAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "facilitie")
@Data
public class Facilities extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    public Facilities() {

    }
}
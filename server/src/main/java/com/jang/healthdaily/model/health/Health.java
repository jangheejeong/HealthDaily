package com.jang.healthdaily.model.health;

import com.jang.healthdaily.model.audit.DateAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "health")
@Data
public class Health extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    @NotNull
    private Boolean isAnaerobic;

    @NotNull
    private long user_no;
}
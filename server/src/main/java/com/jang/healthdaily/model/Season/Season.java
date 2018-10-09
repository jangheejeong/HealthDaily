package com.jang.healthdaily.model.Season;

import com.jang.healthdaily.model.Campsite.Campsite;
import com.jang.healthdaily.model.audit.DateAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "season")
public class Season extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max = 10)
    private String startDate;

    @NotBlank
    @Size(max = 10)
    private String endDate;

    @NotBlank
    @Size(max = 1)
    private String seasonType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "campsite_id")
    private Campsite campsites;

    public void Season (String startDate, String endDate, String seasonType) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.seasonType = seasonType;
    }
}

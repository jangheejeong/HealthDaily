package com.jang.healthdaily.model.Campsite;

import com.jang.healthdaily.model.Facilities.Facilities;
import com.jang.healthdaily.model.audit.DateAudit;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Data
@Alias("campsite")
public class Campsite extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max = 45)
    private String address;

    @NotBlank
    @Size(max = 45)
    private String street;

    @NotBlank
    @Size(max = 40)
    private String businessNumber;

    // 서버단에서 좌표변환
    private long latitude;
    private long longitude;

    @NotBlank
    @Size(max = 45)
    private String phone;

    @NotBlank
    @Size(max = 45)
    private String cell;

    private boolean onlineSettle;
    private boolean bankbookSettle;
    private boolean offlineCardSettle;
    private boolean offlineCashSettle;

    // 운영유형 사용함/사용안함
    private boolean seasonUsed;

    @ManyToMany
    @JoinTable(name="campsite_facilities",
            joinColumns = @JoinColumn(name = "campsite_no"),
            inverseJoinColumns = @JoinColumn(name = "facilitie_no"))
    private List<Facilities> facilities = new ArrayList<Facilities>();


    @NotBlank
    @Size(max = 45)
    private String companyName;

    @NotBlank
    private String companyCode;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="campsite_id")
    private Collection<Site> site;

    private String image;
    private String subImage1;
    private String subImage2;
    private String subImage3;

    @Size(max = 10)
    private String startDate;

    @Size(max = 10)
    private String endDate;

    public Campsite(String businessNumber,
                    String address,
                    String street,
                    String cell,
                    String companyName,
                    String companyCode,
                    long latitude,
                    long longitude,
                    String phone,
                    boolean onlineSettle,
                    boolean bankbookSettle,
                    boolean offlineCardSettle,
                    boolean offlineCashSettle) {
        this.businessNumber = businessNumber;
        this.address = address;
        this.street = street;
        this.cell = cell;
        this.companyName = companyName;
        this.companyCode = companyCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phone = phone;
        this.onlineSettle = onlineSettle;
        this.bankbookSettle = bankbookSettle;
        this.offlineCardSettle = offlineCardSettle;
        this.offlineCashSettle = offlineCashSettle;
    }

    public void addSite(Site p){
        if( site == null ){
            site = new ArrayList<Site>();
        }
        site.add(p);
    }

    public boolean addFacilities(Facilities facilitie) {
        if(facilities == null)
            facilities = new ArrayList<Facilities>();

        return facilities.add(facilitie);
    }
}

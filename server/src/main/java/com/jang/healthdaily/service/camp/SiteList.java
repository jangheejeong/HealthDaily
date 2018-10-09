package com.jang.healthdaily.service.camp;

import com.jang.healthdaily.model.Campsite.Campsite;
import com.jang.healthdaily.repository.Camp.CampRepository;
import com.jang.healthdaily.model.Campsite.Campsite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteList {

    @Autowired
    private CampRepository campRepository;

    public List<Campsite> getSiteList(String companyCode) {
        return campRepository.findByCompanyCode(companyCode);
    }

}

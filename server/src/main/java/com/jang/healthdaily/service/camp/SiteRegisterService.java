package com.jang.healthdaily.service.camp;

import com.jang.healthdaily.repository.Camp.CampRepository;
import com.jang.healthdaily.repository.Camp.SiteRepository;
import com.jang.healthdaily.repository.Category.CategoryRepository;
import com.jang.healthdaily.repository.Facilities.FacilitiesRepository;
import com.jang.healthdaily.repository.Season.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SiteRegisterService {

    @Autowired
    SiteRepository siteRepository;

    @Autowired
    SeasonRepository seasonRepository;

    @Autowired
    private CampRepository campRepository;

    @Autowired
    private FacilitiesRepository facilitiesRepository;

    @Autowired
    private CategoryRepository categoryRepository;

   /* @Transactional
    public void addSiteProc(UserPrincipal currentUser, SiteRequest siteRequest) {
        Campsite campsite = campRepository.findByCompanyCode(currentUser.getCompanyCode().toString()).get(0);
        int siteLength = siteRequest.getPriceInfos().size();
        int FacilitiesSize = siteRequest.getFacilitiesList().size();


        // 캠핑정보 등록
        campsite.setSeasonUsed(siteRequest.isSeasonUsed());
        campsite.setImage(siteRequest.getImage());
        campsite.setSubImage1(siteRequest.getSubImage1());
        campsite.setSubImage2(siteRequest.getSubImage2());
        campsite.setSubImage3(siteRequest.getSubImage3());
        campsite.setStartDate(siteRequest.getStartDate());
        campsite.setEndDate(siteRequest.getEndDate());

        for(int cnt=0; cnt<FacilitiesSize; cnt++) {
            int value = siteRequest.getFacilitiesList().get(cnt);
            Facilities facilities = facilitiesRepository.findById(value);
            campsite.addFacilities(facilities);
        }

        // 사이트 정보 등록
        for(int cnt=0; cnt<siteLength; cnt++) {
            Site site = new Site(
                siteRequest.getPriceInfos().get(cnt).getName(),
                getBarcode(),
                campsite.getId(),
                siteRequest.getSiteInfos().get(cnt).getAllowedPeople(),
                siteRequest.getPriceInfos().get(cnt).getWeekdayDefaultPrice(),
                siteRequest.getPriceInfos().get(cnt).getWeekendDefaultPrice(),
                siteRequest.getPriceInfos().get(cnt).getWeekdaySeasonPrice(),
                siteRequest.getPriceInfos().get(cnt).getWeekendSeasonPrice(),
                siteRequest.getPriceInfos().get(cnt).getWeekdayHigherSeasonPrice(),
                siteRequest.getPriceInfos().get(cnt).getWeekendHigherSeasonPrice(),
                siteRequest.getSiteInfos().get(cnt).getSiteCount(),
                siteRequest.getSiteInfos().get(cnt).getCategoryId()
            );

            campsite.addSite(site);
            campRepository.save(campsite);
        }
    }*/
}
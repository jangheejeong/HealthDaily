package com.jang.healthdaily.service.Facilities;

import com.jang.healthdaily.model.Facilities.Facilities;
import com.jang.healthdaily.payload.Facilities.FacilitiesRequest;
import com.jang.healthdaily.repository.Camp.CampRepository;
import com.jang.healthdaily.repository.Facilities.FacilitiesRepository;
import com.jang.healthdaily.model.Facilities.Facilities;
import com.jang.healthdaily.payload.Facilities.FacilitiesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilitiesService {

    @Autowired
    FacilitiesRepository facilitiesRepository;

    /*@Autowired
    FacilitiesMappingRepository facilitiesMappingRepository;*/

    @Autowired
    CampRepository campRepository;


    public void addFacilities(FacilitiesRequest facilitiesRequest) {
        Facilities facilitie = new Facilities();
        facilitie.setName(facilitiesRequest.getName());
        facilitiesRepository.save(facilitie);
    }

   /* public void addFacilitiesToCampsite(FacilitiesToCampsiteRequest facilitiesMappingRequest, String campsiteCode) {
        Campsite campsite = campRepository.findByCompanyCode(campsiteCode).get(0);
        FacilitiesMapping facilitiesMapping = new FacilitiesMapping(
                facilitiesMappingRequest.getFacilitiesId(),
                campsite.getId()
        );

        facilitiesMappingRepository.save(facilitiesMapping);
    }
*/
    public List<Facilities> getFacilitiesList() {
        List<Facilities> result = facilitiesRepository.findAll();

        return result;
    }

}
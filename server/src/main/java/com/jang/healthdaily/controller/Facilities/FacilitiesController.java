package com.jang.healthdaily.controller.Facilities;

import com.jang.healthdaily.payload.ApiResponse;
import com.jang.healthdaily.payload.Facilities.FacilitiesRequest;
import com.jang.healthdaily.service.Facilities.FacilitiesService;
import com.jang.healthdaily.payload.ApiResponse;
import com.jang.healthdaily.payload.Facilities.FacilitiesRequest;
import com.jang.healthdaily.service.Facilities.FacilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * 부대시설 컨트롤러
 * */
@RestController
@RequestMapping("/api")
public class FacilitiesController {

    @Autowired
    private FacilitiesService fategoryService;

    @PostMapping("/facilities")
    public ResponseEntity<?> addFacilities(@Valid @RequestBody FacilitiesRequest facilitiesRequest) {
        fategoryService.addFacilities(facilitiesRequest);

        return ResponseEntity.ok(new ApiResponse(true, "facilities added successfully"));
    }

//    @PostMapping("/user/facilities")
 /*   public ResponseEntity<?> addFacilitiesToCampsite(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody FacilitiesToCampsiteRequest facilitiesToCampsiteRequest) {
        String companyCode = currentUser.getCompanyCode();
        fategoryService.addFacilitiesToCampsite(facilitiesToCampsiteRequest, companyCode);

        return ResponseEntity.ok(new ApiResponse(true, "facilities added to campsite successfully"));
    }*/

    @GetMapping("/facilities")
    public ResponseEntity<?> getFacilitiesList() {
        return ResponseEntity.ok(fategoryService.getFacilitiesList());
    }
}



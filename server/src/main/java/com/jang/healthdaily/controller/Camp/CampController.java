package com.jang.healthdaily.controller.Camp;

import com.jang.healthdaily.service.camp.SiteList;
import com.jang.healthdaily.service.camp.SiteRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 캠핑 컨트롤러
 * */
@RestController
@RequestMapping("/api")
public class CampController {

    @Autowired
    private SiteRegisterService siteRegisterService;

    @Autowired
    private SiteList siteListService;

/*
    @PostMapping("/site")
    public ResponseEntity<?> addSite(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody SiteRequest siteRequest) {

        siteRegisterService.addSiteProc(currentUser, siteRequest);

        return ResponseEntity.ok("Success");
    }

    @GetMapping("/site")
    public ResponseEntity<?> getSiteList(@CurrentUser UserPrincipal currentUser) {
        List<Campsite> result = siteListService.getSiteList(currentUser.getCompanyCode());

        return ResponseEntity.ok(result);
    }*/
}



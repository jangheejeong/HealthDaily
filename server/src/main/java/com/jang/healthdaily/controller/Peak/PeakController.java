package com.jang.healthdaily.controller.Peak;

import com.jang.healthdaily.service.camp.SiteList;
import com.jang.healthdaily.service.camp.SiteRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PeakController {

    @Autowired
    private SiteRegisterService siteRegisterService;

    @Autowired
    private SiteList siteListService;


   /* @PostMapping("/peak")
    public ResponseEntity<?> addSite(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody SiteRequest siteRequest) {
        siteRegisterService.addSiteProc(currentUser, siteRequest);

        return ResponseEntity.ok("Success");
    }*/
}
package com.jang.healthdaily.controller.health;

import com.jang.healthdaily.payload.ApiResponse;
import com.jang.healthdaily.payload.healths.HealthRequest;
import com.jang.healthdaily.security.CurrentUser;
import com.jang.healthdaily.security.UserPrincipal;
import com.jang.healthdaily.service.healths.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 운통 타입 추가/삭제
 * */
@RestController
@RequestMapping("/api")
public class HealthController {

    @Autowired
    private HealthService healthService;

    @PostMapping("/healths")
    public ResponseEntity<?> addFacilities(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody HealthRequest healthRequest) {
        healthService.addHealth(currentUser, healthRequest);
        return ResponseEntity.ok(new ApiResponse(true, "healths added successfully"));
    }

    @GetMapping("/healths")
    public ResponseEntity<?> getHealths() {
        return ResponseEntity.ok(healthService.getHealths());
    }
}

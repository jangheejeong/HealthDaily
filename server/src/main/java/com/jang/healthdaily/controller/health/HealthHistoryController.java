package com.jang.healthdaily.controller.health;

import com.jang.healthdaily.payload.ApiResponse;
import com.jang.healthdaily.payload.healths.HealthHistoryRequest;
import com.jang.healthdaily.payload.healths.HealthRequest;
import com.jang.healthdaily.security.CurrentUser;
import com.jang.healthdaily.security.UserPrincipal;
import com.jang.healthdaily.service.healths.HealthHistoryService;
import com.jang.healthdaily.service.healths.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 운통 기록 추가/삭제/수정
 * */
@RestController
@RequestMapping("/api")
public class HealthHistoryController {

    @Autowired
    private HealthHistoryService healthHistoryService;

    @PostMapping("/history")
    public ResponseEntity<?> addHistory(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody HealthHistoryRequest healthHistoryRequest) {
        healthHistoryService.addHealthHistory(currentUser, healthHistoryRequest);
        return ResponseEntity.ok(new ApiResponse(true, "healths added successfully"));
    }

    @GetMapping("/history")
    public ResponseEntity<?> getHistory() {
        return ResponseEntity.ok(healthHistoryService.getHealths());
    }
}


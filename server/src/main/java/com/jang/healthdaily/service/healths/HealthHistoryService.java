package com.jang.healthdaily.service.healths;

import com.jang.healthdaily.model.health.Health;
import com.jang.healthdaily.model.health.HealthHistory;
import com.jang.healthdaily.payload.healths.HealthHistoryRequest;
import com.jang.healthdaily.payload.healths.HealthRequest;
import com.jang.healthdaily.repository.health.HealthHistoryRepository;
import com.jang.healthdaily.repository.health.HealthRepository;
import com.jang.healthdaily.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthHistoryService {

    @Autowired
    HealthHistoryRepository healthHistoryRepository;

    public void addHealthHistory(UserPrincipal currentUser, HealthHistoryRequest healthHistoryRequest)
    {
        HealthHistory healthHistory = new HealthHistory();
        healthHistory.setName(healthHistoryRequest.getName());
        healthHistory.setIsAnaerobic(healthHistoryRequest.getIsAnaerobic());
        healthHistory.setUser_no(currentUser.getId());

        healthHistoryRepository.save(healthHistory);
    }

    public List<HealthHistory> getHistory()
    {
        List<HealthHistory> result = healthHistoryRepository.findAll();

        return result;
    }

    public List<HealthHistory> modifyHistory()
    {
        List<HealthHistory> result = healthHistoryRepository.findAll();

        return result;
    }

    public List<HealthHistory> deleteHistory()
    {
        List<HealthHistory> result = healthHistoryRepository.findAll();

        return result;
    }
}
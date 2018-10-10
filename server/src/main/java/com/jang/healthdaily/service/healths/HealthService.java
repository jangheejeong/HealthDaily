package com.jang.healthdaily.service.healths;

import com.jang.healthdaily.model.health.Health;
import com.jang.healthdaily.payload.healths.HealthRequest;
import com.jang.healthdaily.repository.Camp.CampRepository;
import com.jang.healthdaily.repository.UserRepository;
import com.jang.healthdaily.repository.health.HealthRepository;
import com.jang.healthdaily.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthService {

    @Autowired
    HealthRepository healthRepository;

    public void addHealth(UserPrincipal currentUser, HealthRequest healthRequest)
    {
        Health health = new Health();
        health.setName(healthRequest.getName());
        health.setIsAnaerobic(healthRequest.getIsAnaerobic());
        health.setUser_no(currentUser.getId());

        healthRepository.save(health);
    }

    public List<Health> getHealths()
    {
        List<Health> result = healthRepository.findAll();

        return result;
    }
}
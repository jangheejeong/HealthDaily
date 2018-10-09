package com.jang.healthdaily.repository.health;

import com.jang.healthdaily.model.health.Health;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthRepository extends JpaRepository<Health, Long> {
    List<Health> findAll();
    Health findById(long healthId);
}
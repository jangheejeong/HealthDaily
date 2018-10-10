package com.jang.healthdaily.repository.health;

import com.jang.healthdaily.model.health.Health;
import com.jang.healthdaily.model.health.HealthHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthHistoryRepository extends JpaRepository<HealthHistory, Long> {
    List<HealthHistory> findAll();
    Health findById(long healthHistoryId);
}
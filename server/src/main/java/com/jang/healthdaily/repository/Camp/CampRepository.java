package com.jang.healthdaily.repository.Camp;


import com.jang.healthdaily.model.Campsite.Campsite;
import com.jang.healthdaily.model.Campsite.Campsite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CampRepository extends JpaRepository<Campsite, Long> {
    Optional<Campsite> findById(long siteId);
    List<Campsite> findByCompanyCode(String companyCode);
}
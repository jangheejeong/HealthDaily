package com.jang.healthdaily.repository.Camp;


import com.jang.healthdaily.model.Campsite.Site;
import com.jang.healthdaily.model.Campsite.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
    Optional<Site> findById(Long siteId);
}
package com.jang.healthdaily.repository.Facilities;

import com.jang.healthdaily.model.Facilities.Facilities;
import com.jang.healthdaily.model.Facilities.Facilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FacilitiesRepository extends JpaRepository<Facilities, Long> {
    List<Facilities> findAll();
    Facilities findById(long facilitiesId);
}
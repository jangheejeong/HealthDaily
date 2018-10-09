package com.jang.healthdaily.repository;

import com.jang.healthdaily.model.Role.Role;
import com.jang.healthdaily.model.Role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
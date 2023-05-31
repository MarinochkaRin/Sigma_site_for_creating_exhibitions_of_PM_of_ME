package com.mryndina.exhibitions.repository;

import com.mryndina.exhibitions.entity.UserIdNameRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserIdNameRoleRepository extends JpaRepository<UserIdNameRole, Long> {
}
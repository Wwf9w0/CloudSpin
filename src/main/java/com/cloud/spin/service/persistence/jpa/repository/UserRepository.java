package com.cloud.spin.service.persistence.jpa.repository;

import com.cloud.spin.service.persistence.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

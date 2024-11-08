package com.cloud.spin.service.persistence.jpa.repository;

import com.cloud.spin.service.persistence.jpa.entity.ServerEntity;
import com.cloud.spin.service.persistence.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServerRepository extends JpaRepository<ServerEntity, Long> {

    List<ServerEntity> findByUser(UserEntity user);
}

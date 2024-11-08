package com.cloud.spin.service.persistence.jpa.service;

import com.cloud.spin.service.persistence.jpa.entity.UserEntity;
import com.cloud.spin.service.persistence.jpa.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserPersistenceService {

    private final UserRepository userRepository;

    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
        log.info("saved user -> {}", userEntity.getUserName());
    }

    public List<UserEntity> listUsers() {
        return userRepository.findAll();
    }
}

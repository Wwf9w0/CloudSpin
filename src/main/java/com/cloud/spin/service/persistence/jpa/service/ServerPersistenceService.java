package com.cloud.spin.service.persistence.jpa.service;

import com.cloud.spin.service.persistence.jpa.entity.ServerEntity;
import com.cloud.spin.service.persistence.jpa.entity.UserEntity;
import com.cloud.spin.service.persistence.jpa.repository.ServerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServerPersistenceService {

    private final ServerRepository serverRepository;

    public void saveServer(String containerId, String containerName, UserEntity userEntity) {
        ServerEntity server = ServerEntity.builder()
                .containerId(containerId)
                .containerName(containerName)
                .user(userEntity)
                .build();
        serverRepository.save(server);
    }

    public List<ServerEntity> getUserServerList(String userId) {
        UserEntity userEntity = new UserEntity();
        return serverRepository.findByUser(userEntity);
    }

    public Optional<ServerEntity> getServerById(Long id) {
        return Optional.of(serverRepository.findById(id).orElseThrow());
    }

    public void deleteServer(Long id) {
        serverRepository.deleteById(id);
    }
}

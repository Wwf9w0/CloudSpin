package com.cloud.spin.service.client;

import com.cloud.spin.service.service.DockerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ICloudSpinService implements CloudSpinClient {

    private final DockerService dockerService;

    @Override
    public String createVirtualMachine(String containerName) {
        return dockerService.createUbuntuContainer(containerName);
    }

    @Override
    public void createDataBaseInstance() {
        //TODO implemented
    }

    @Override
    public void createRedisInstance() {
        //TODO implemented
    }

    @Override
    public void createApacheKafkaInstance() {
        //TODO implemented
    }

    @Override
    public void createMongoDbInstance() {
        //TODO implemented
    }

    @Override
    public boolean isContainerRunning(String containerId) {
        return dockerService.isContainerRunning(containerId);
    }

    @Override
    public String getContainerSSHInfo(String containerId) {
        return dockerService.getContainerSSHInfo(containerId);
    }

    @Override
    public void stopContainer(String containerId) {
        dockerService.stopContainer(containerId);
    }

    @Override
    public void removeContainer(String containerId) {
        dockerService.removeContainer(containerId);
    }
}

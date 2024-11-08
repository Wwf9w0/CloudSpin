package com.cloud.spin.service.service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.StartContainerCmd;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import com.github.dockerjava.core.DockerClientBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DockerService {

    private final DockerClient dockerClient = DockerClientBuilder.getInstance().build();

    public String createUbuntuContainer(String containerName) {
        ExposedPort tcp22 = ExposedPort.tcp(22);
        Ports portBindings = new Ports();
        portBindings.bind(tcp22, Ports.Binding.bindPort(2222));

        CreateContainerResponse container = dockerClient.createContainerCmd("ubuntu:latest")
                .withName(containerName)
                .withExposedPorts(tcp22)
                .withPortBindings(new PortBinding(Ports.Binding.bindPort(2222), tcp22))
                .withCmd("/bin/bash", "-c", "apt update && apt install -y openssh-server && service ssh start && tail -f /dev/null")
                .exec();

        try (StartContainerCmd startContainerCmd = dockerClient.startContainerCmd(container.getId())) {
            startContainerCmd.exec();
        } catch (Exception e) {
            throw new RuntimeException("Ubuntu container failed to start!");
        }
        return container.getId();
    }

    public boolean isContainerRunning(String containerId) {
        return dockerClient.inspectContainerCmd(containerId).exec().getState().getRunning();
    }

    public String getContainerSSHInfo(String containerId) {
        String ip = dockerClient.inspectContainerCmd(containerId).exec().getNetworkSettings().getIpAddress();
        int port = 2222;
        return "SSH connection IP: " + ip + ", Port: " + port;
    }

    public void stopContainer(String containerId){
        dockerClient.stopContainerCmd(containerId).exec();
    }

    public void removeContainer(String containerId){
        dockerClient.removeContainerCmd(containerId).withForce(true).exec();
    }
}

package com.cloud.spin.service.service;

import com.cloud.spin.service.client.ICloudSpinService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VMInstanceService {

    private final ICloudSpinService cloudSpinService;

    @Async
    public String createNewInstanceVM(String containerName) {
        return cloudSpinService.createVirtualMachine(containerName);
    }

    public String getSSHInfo(String containerId) {
        return cloudSpinService.getContainerSSHInfo(containerId);
    }
}

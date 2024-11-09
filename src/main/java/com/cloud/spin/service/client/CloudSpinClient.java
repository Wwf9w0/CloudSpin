package com.cloud.spin.service.client;

public interface CloudSpinClient {

   String createVirtualMachine(String containerName);

   void createDataBaseInstance();

   void createRedisInstance();

   void createApacheKafkaInstance();

   void createMongoDbInstance();

   boolean isContainerRunning(String containerId);

   String getContainerSSHInfo(String containerId);

   void stopContainer(String containerId);

   void removeContainer(String containerId);
}

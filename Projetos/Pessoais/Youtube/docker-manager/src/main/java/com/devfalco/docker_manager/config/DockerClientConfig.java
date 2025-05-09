package com.devfalco.docker_manager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;

@Configuration
public class DockerClientConfig {

  @Value("${docker.socket.path}")
  private String dockerSocketpath;

  @Bean
  public DockerClient buildDockerClient(){
    DefaultDockerClientConfig.Builder dockerClientConfigBuilder = DefaultDockerClientConfig.createDefaultConfigBuilder();

    if(this.dockerSocketpath != null && this.dockerSocketpath.startsWith("tcp://")){
      dockerClientConfigBuilder.withDockerHost(dockerSocketpath).withDockerTlsVerify(false);
    }

    DefaultDockerClientConfig dockerClientConfig = dockerClientConfigBuilder.build();

    ApacheDockerHttpClient dockerHttpClient = new ApacheDockerHttpClient.Builder().dockerHost(dockerClientConfig.getDockerHost()).build();

    return DockerClientBuilder.getInstance(dockerClientConfig).withDockerHttpClient(dockerHttpClient).build();
  }
}

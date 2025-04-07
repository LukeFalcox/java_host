package com.devfalco.eventos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration // Essa notação ela criará a instancia do objeto amazons3 com as credenciais para conseguir fazer o upload lá na s3
public class AWSConfig {

  @Value("${aws.region}") // Ele pegará o valor do application.properties
  private String awsRegion;

  @Bean // Essa notação ira servir para o spring identificar que esse metodo cria a instancia correta do amazonS3
  public AmazonS3 createS3Instance(){
    return AmazonS3ClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).withRegion(awsRegion).build(); // Essa função especifica a região que usariamos e o standary para as credencias que estiverem configuradas na sua maquina 
  }
}

// Eu não tenho configurado na maquina, vou er como configurar depois
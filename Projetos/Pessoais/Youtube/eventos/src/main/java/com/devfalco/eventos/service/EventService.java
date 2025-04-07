package com.devfalco.eventos.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.devfalco.eventos.domain.event.Event;
import com.devfalco.eventos.domain.event.EventRequestDTO;
import com.devfalco.eventos.repositories.EventRepository;

@Service
public class EventService {

  @Value("${aws.bucket.name}") // Ele pegará o valor do application.properties
  private String bucketName;

  @Autowired
  private AmazonS3 s3client;

  @Autowired
  private EventRepository repository;


  public Event createEvent(EventRequestDTO data){
    String imgUrl = null;

    if (data.image() != null) {
      imgUrl = this.uploadImg(data.image());
    }

    Event newEvent = new Event();
    newEvent.setTitle(data.title());
    newEvent.setDescription(data.description());
    newEvent.setEventUrl(data.eventUrl());
    newEvent.setDate(new Date(data.date()));
    newEvent.setImgUrl(imgUrl);
    newEvent.setRemote(data.remote());

    repository.save(newEvent);

    return newEvent;
  }

// ! Conexão com a AWS para conectar com o java e fazer o upload.

  private String uploadImg(MultipartFile multipartFile){
    String filename = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();
    try {
      File file = this.convertMultipartToFile(multipartFile);
      s3client.putObject(bucketName,filename,file);
      file.delete();
      return s3client.getUrl(bucketName, filename).toString();
    } catch (Exception e) {
      System.out.println("Erro ao subir arquivo");
      e.printStackTrace(); // Isso imprime o erro real no console
      return "";
    }
  }

  private File convertMultipartToFile(MultipartFile multipartFile) throws IOException{
    
    File convFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
    FileOutputStream fos = new FileOutputStream(convFile);
    fos.write(multipartFile.getBytes());
    fos.close();
    return convFile;
  }
}

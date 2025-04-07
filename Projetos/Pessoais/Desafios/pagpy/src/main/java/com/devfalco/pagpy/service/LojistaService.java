package com.devfalco.pagpy.service;

import org.springframework.stereotype.Service;

import com.devfalco.pagpy.model.LojistaModel;
import com.devfalco.pagpy.model.LojistaRequestDTO;
import com.devfalco.pagpy.repository.LojistaRepository;

@Service
public class LojistaService {
  LojistaRepository lojistaRepository;

  public LojistaService(LojistaRepository lojistaRepository){
    this.lojistaRepository = lojistaRepository;
  }

  public LojistaModel createLojistaModel(LojistaRequestDTO data){
    LojistaModel lojistaModel = new LojistaModel();
    lojistaModel.setUsername(data.username());
    lojistaModel.setCpf(data.cpf());
    lojistaModel.setEmail(data.email());
    lojistaModel.setPassword(data.password());
    lojistaModel.setPatrimonio(0.0);
    return lojistaRepository.save(lojistaModel);
  }
}

package com.devfalco.pagpy.service;

import org.springframework.stereotype.Service;

import com.devfalco.pagpy.model.TransferDTO;
import com.devfalco.pagpy.model.UserModel;
import com.devfalco.pagpy.model.UserRequestDTO;
import com.devfalco.pagpy.repository.UserRepository;

@Service
public class UserService {
  UserRepository userRepository;
  UserModel userModel = new UserModel();
  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public UserModel creatUserModel(UserRequestDTO data){
    userModel.setUsername(data.username());
    userModel.setCpf(data.cpf());
    userModel.setEmail(data.email());
    userModel.setPassword(data.password());
    userModel.setPatrimonio(0.0);
    userModel.setToken(null);
    return userRepository.save(userModel);
  }

  public UserModel transfer(TransferDTO data){
    Integer type = data.identificador().indexOf("@");
    if (type > -1) {
      userModel = userRepository.findByEmail(data.identificador());
      userModel.setPatrimonio(userModel.getPatrimonio() + data.valor());
      return userRepository.save(userModel);
    } else {
      userModel = userRepository.findByCpf(data.identificador());
      userModel.setPatrimonio(userModel.getPatrimonio() + data.valor());
      return userRepository.save(userModel);
    }
  }

  public Boolean login(String identificador, String password, String token){
    Integer type = identificador.indexOf("@"); // email ou como cpf
    if (type > -1) {
      userModel = userRepository.findByEmail(identificador);
    } else {
      userModel = userRepository.findByCpf(identificador);
    }
    if (password.equals(userModel.getPassword())) {
      userModel.setToken(token);
      userRepository.save(userModel);
      return true;
    } else {
      return false;
    }
  } 

  public UserModel getUser(String identificador){
    Integer type = identificador.indexOf("@"); // email ou como cpf
    if (type > -1) {
      userModel = userRepository.findByEmail(identificador);
    } else {
      userModel = userRepository.findByCpf(identificador);
    }

    return userModel;
  }

  public String getToken(String identificador){
    Integer type = identificador.indexOf("@"); // email ou como cpf
    if (type > -1) {
      userModel = userRepository.findByEmail(identificador);
    } else {
      userModel = userRepository.findByCpf(identificador);
    }

    if (userModel == null) {
      return null;
  }

    return userModel.getToken();
  }
}

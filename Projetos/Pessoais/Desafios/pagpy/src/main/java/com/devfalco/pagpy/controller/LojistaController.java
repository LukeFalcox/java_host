package com.devfalco.pagpy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devfalco.pagpy.model.LojistaModel;
import com.devfalco.pagpy.model.LojistaRequestDTO;
import com.devfalco.pagpy.service.LojistaService;

@RestController
@RequestMapping("/pagpy/lojistas")
public class LojistaController {
  LojistaService lojistaService;
  public LojistaController(LojistaService lojistaService){
    this.lojistaService = lojistaService;
  }

  @PostMapping("/newlojista")
  public LojistaModel createLojista(@RequestParam("username") String username,
  @RequestParam("cpf") String cpf,
  @RequestParam("email") String email,
  @RequestParam("password") String password
  ) {
    LojistaRequestDTO lojistaRequestDTO = new LojistaRequestDTO(username, password, cpf, email);
    return lojistaService.createLojistaModel(lojistaRequestDTO);
  }
}

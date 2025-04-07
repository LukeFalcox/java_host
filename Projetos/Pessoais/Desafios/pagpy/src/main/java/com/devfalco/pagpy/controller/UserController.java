package com.devfalco.pagpy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devfalco.pagpy.model.TransferDTO;
import com.devfalco.pagpy.model.UserModel;
import com.devfalco.pagpy.model.UserRequestDTO;
import com.devfalco.pagpy.service.JwtUtil;
import com.devfalco.pagpy.service.UserService;

@RestController
@RequestMapping("/pagpy/users")
public class UserController {
UserService userService;

public UserController(UserService userService){
  this.userService = userService;
}

@PostMapping("/newuser")
public UserModel createuser(@RequestParam("username") String username,
@RequestParam("cpf") String cpf,
@RequestParam("email") String email,
@RequestParam("password") String password
) {
  try {
    UserRequestDTO userRequestDTO = new UserRequestDTO(username, cpf, email, password);
    return userService.creatUserModel(userRequestDTO);
  } catch (Exception e) {
    return null;
  }
}

@PostMapping("/transfer")
public String transferUser(@RequestParam("identificacao") String identificacao, @RequestParam("valor") Double valor){
  try {
    String validate = JwtUtil.validateToken(token);
  } catch (Exception e) {
    // TODO: handle exception
  }
}

@PostMapping("/login")
  public String login(@RequestParam("identificacao") String identificacao, @RequestParam("password") String password){
    if (userService.login(identificacao, password)) {
      String token = JwtUtil.generateToken(identificacao);
      return token;
    } else {
      return null;
    }
  }
  
}
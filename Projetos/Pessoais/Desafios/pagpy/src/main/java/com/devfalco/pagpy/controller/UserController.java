package com.devfalco.pagpy.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devfalco.pagpy.model.TransferDTO;
import com.devfalco.pagpy.model.TransferModel;
import com.devfalco.pagpy.model.UserModel;
import com.devfalco.pagpy.model.UserRequestDTO;
import com.devfalco.pagpy.service.JwtUtil;
import com.devfalco.pagpy.service.UserService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/pagpy/users")
public class UserController {
UserService userService;
Gson gson = new Gson();
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

@PostMapping("/getuser")
public UserModel getUser(@RequestParam("identificador") String identificacao) {
    return userService.getUser(identificacao);
}


@PostMapping("/transfer")
public String transferUser(
  @RequestHeader("Authorization") String authHeader,
  @RequestParam("destinatario") String destinatario, 
  @RequestParam("valor") Double valor){
  try {
    String token = authHeader.replace("Bearer","").trim();
    String remetente = JwtUtil.validateToken(token);
    if (remetente != null) {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://util.devi.tools/api/v2/authorize")).GET().build();
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
      TransferModel transfer = gson.fromJson(response.body(), TransferModel.class);
      if ("sucess".equals(transfer.getStatus())) {
        TransferDTO transferDTO = new TransferDTO(destinatario, valor, remetente); // 
         userService.transfer(transferDTO);
        return "Sucesso";
      }
    } 
  } catch (Exception e) {
    return "Erro ao realizar a transferencia: "+ e.getMessage();
  }
  return "Erro na validação";
}

@PostMapping("/login")
  public ResponseEntity<String> login(@RequestParam("identificador") String identificacao, @RequestParam("password") String password){
    String token = JwtUtil.generateToken(identificacao);
    System.out.println(token);
    if (userService.login(identificacao, password,token)) {
      return ResponseEntity.ok(token);
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }
  }
  
}
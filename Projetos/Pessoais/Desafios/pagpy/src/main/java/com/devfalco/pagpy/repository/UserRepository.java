package com.devfalco.pagpy.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.devfalco.pagpy.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Long> {
  public UserModel findByCpf(String cpf);
  public UserModel findByEmail(String email);
}

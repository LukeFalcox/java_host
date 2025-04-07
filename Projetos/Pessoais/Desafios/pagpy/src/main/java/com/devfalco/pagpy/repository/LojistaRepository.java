package com.devfalco.pagpy.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.devfalco.pagpy.model.LojistaModel;

public interface LojistaRepository extends JpaRepository<LojistaModel,Long> {
    LojistaModel findByCpf(String cpf);
    LojistaModel findByEmail(String email);
}

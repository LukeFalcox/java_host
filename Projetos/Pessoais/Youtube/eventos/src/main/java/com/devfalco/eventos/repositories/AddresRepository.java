package com.devfalco.eventos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devfalco.eventos.domain.address.Address;

public interface AddresRepository extends JpaRepository<Address,UUID> {

  
}
package com.devfalco.eventos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devfalco.eventos.domain.coupon.Coupon;

public interface CouponRepository extends JpaRepository<Coupon,UUID>{

  
} 
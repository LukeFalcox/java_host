package com.devfalco.eventos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devfalco.eventos.domain.event.Event;

public interface EventRepository extends JpaRepository<Event,UUID>{
}
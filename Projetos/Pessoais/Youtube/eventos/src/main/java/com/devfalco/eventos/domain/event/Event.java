package com.devfalco.eventos.domain.event;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "event") // Define a tabela da nossa classe e como ela se chama
@Entity // Define que a nossa classe é uma entidade
@Setter // Gera automaticamente metodos de settters dos argumentos
@Getter // Gera automaticamnete metodos de getters dos argumentos
@NoArgsConstructor// Gera automaticamente um construtor que não recebe nem um argumento
@AllArgsConstructor // Gera automaticamente um construtor que recebe todos os argumentos
public class Event {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;

  private String title;

  private String description;

  private String imgUrl;

  private String eventUrl;

  private Boolean remote;

  private Date date;
}

package com.devfalco.eventos.domain.coupon;

import java.sql.Date;
import java.util.UUID;

import com.devfalco.eventos.domain.event.Event;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "coupon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;

  private String code;
  private Integer discount;
  private Date valid;

  @ManyToOne // Relação de um para muitos
  @JoinColumn(name = "event_id") // Comparação de FK que é o even_id para o PK do Event
  private Event event;

}

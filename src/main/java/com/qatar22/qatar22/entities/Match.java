package com.qatar22.qatar22.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Match {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long matchid;
  private Long pays1id;
  private Long pays2id;
  private String nom1;
  private int scorepays1;
  private int scorepays2;
  private String nom2;
  private String lieu;
  private LocalDate date;
  private Long arbitreid;
}

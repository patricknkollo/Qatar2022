package com.qatar22.qatar22.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Buteur {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long buteurid;
  private Long joueurid;
  private String nom;
  private String prenom;
  private int buts;
}

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
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class Arbitre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long arbitreid;
  private String nom;
  private String prenom;
  private Long personid;
}

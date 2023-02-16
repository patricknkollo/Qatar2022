package com.qatar22.qatar22.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Club {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long clubid;
  private String nom;
  private String ville;
  private String pays;
  private Long paysid;
}

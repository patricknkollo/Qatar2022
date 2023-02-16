package com.qatar22.qatar22.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pays {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long paysid;
  private String nom;
  private int habitants;
  private int cdms;
  private int superficie;
}

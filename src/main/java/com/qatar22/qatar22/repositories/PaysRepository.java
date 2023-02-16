package com.qatar22.qatar22.repositories;

import com.qatar22.qatar22.entities.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface PaysRepository extends JpaRepository <Pays, Long> {
}

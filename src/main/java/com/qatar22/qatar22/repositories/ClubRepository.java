package com.qatar22.qatar22.repositories;

import com.qatar22.qatar22.entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface ClubRepository extends JpaRepository<Club, Long> {
}

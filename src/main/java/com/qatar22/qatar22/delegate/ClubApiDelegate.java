package com.qatar22.qatar22.delegate;

import com.qatar22.qatar22.api.ClubApi;
import com.qatar22.qatar22.entities.Club;
import com.qatar22.qatar22.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClubApiDelegate implements ClubApi {

  @Autowired
  private ClubService service;

  @Override
  public ResponseEntity<List<Club>> getAllClubsFromDatabase() {
    return service.getAllClubs();
  }
}

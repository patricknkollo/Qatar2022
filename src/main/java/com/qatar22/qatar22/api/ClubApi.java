package com.qatar22.qatar22.api;

import com.qatar22.qatar22.entities.Club;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Component
@RequestMapping(path = "/api/club/controller")
@CrossOrigin(origins = "*")
public interface ClubApi {

  @RequestMapping(path = "/clubs", method = RequestMethod.GET)
  public ResponseEntity<List<Club>> getAllClubsFromDatabase();
}

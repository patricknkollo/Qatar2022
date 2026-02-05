package com.qatar22.qatar22.controllers;

import com.qatar22.qatar22.entities.Match;
import com.qatar22.qatar22.services.MatchService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RequestMapping(path = "/api/match/controller", produces = MediaType.APPLICATION_JSON_VALUE)
@Component
@Controller
@CrossOrigin(origins = "*")
public class MatchController {

  @Autowired
  private MatchService service;

  @RequestMapping(path = "/matchs", method = RequestMethod.GET)
  public ResponseEntity<List<Match>> findAllTheMatchs(){
    return service.getAllGames();
  }

  @RequestMapping(path = "/save/match", method = RequestMethod.POST)
  public @ResponseBody
  Match saveGameData(@RequestBody Match match) {
    return service.saveGame(match);
  }

  @RequestMapping(path = "/update/match", method = RequestMethod.PUT)
  public @ResponseBody
  Match updatePersonData(@RequestParam("ID") Long id, @RequestBody Match match) {
    return service.updateGame(id, match);
  }

  @RequestMapping(path = "/match/report", produces = MediaType.APPLICATION_PDF_VALUE)
  public @ResponseBody
  ResponseEntity<byte[]> getGameReportData() throws JRException, FileNotFoundException {
    return service.getGameReport();
  }

  @RequestMapping(path = "/match/{matchid}" , method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<Match> getPersonById(@PathVariable("matchid") Long id) {
    return service.getGameById(id);
  }
}

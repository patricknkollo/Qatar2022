package com.qatar22.qatar22.controllers;

import com.qatar22.qatar22.entities.Joueur;
import com.qatar22.qatar22.services.JoueurService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/joueur/controller", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
public class JoueurController {

  @Autowired
  private JoueurService service;

  @RequestMapping(path = "/players", method = RequestMethod.GET)
  public ResponseEntity<List<Joueur>> findAllThePlayers(){
    return service.getAllPlayers();
  }

  @RequestMapping(path = "/save/player", method = RequestMethod.POST)
  public @ResponseBody
  Joueur saveJoueurData(@RequestBody Joueur joueur) {
    return service.saveJoueur(joueur);
  }

  @RequestMapping(path = "/update/player", method = RequestMethod.PUT)
  public @ResponseBody
  Joueur updatePersonData(@RequestParam("ID") Long id, @RequestBody Joueur joueur) {
    return service.updateJoueur(id, joueur);
  }

  @RequestMapping(path = "/player/report", produces = MediaType.APPLICATION_PDF_VALUE)
  public @ResponseBody
  ResponseEntity<byte[]> getPersonsReportData() throws JRException, FileNotFoundException {
    return service.getJoueurReport();
  }

  @RequestMapping(path = "/joueur/{joueurid}" , method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<Joueur> getPersonById(@PathVariable("joueurid") Long id) {
    return service.getJoueurById(id);
  }
}

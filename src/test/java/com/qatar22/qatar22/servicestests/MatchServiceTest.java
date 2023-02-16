package com.qatar22.qatar22.servicestests;

import com.qatar22.qatar22.entities.Match;
import com.qatar22.qatar22.repositories.MatchRepository;
import com.qatar22.qatar22.services.MatchService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MatchServiceTest {

    @InjectMocks
    private MatchService service;
    @Mock
    private MatchRepository repository;

    private Match match1 = new Match();
    private Match match2 = new Match();

    @BeforeAll
    void setup(){
        match1.setArbitreid(1L);
        match1.setLieu("doha");
        match1.setDate(LocalDate.of(2022,11,19));
        match1.setNom2("deutschland");
        match1.setNom1("cameroun");
        match1.setPays1id(1L);
        match1.setPays2id(2L);
        match1.setScorepays1(2);
        match1.setScorepays2(2);
        match1.setMatchid(1L);

        match2.setArbitreid(1L);
        match2.setLieu("doha");
        match2.setDate(LocalDate.of(2022,11,19));
        match2.setNom1("qatar");
        match2.setNom2("saoud-arabia");
        match2.setPays1id(3L);
        match2.setPays2id(4L);
        match2.setScorepays1(0);
        match2.setScorepays2(0);
        match2.setMatchid(2L);
    }

    @Order(1)
    @Test
    void test_getAllCountries(){
        List<Match> matches = Arrays.asList(match1, match2);
        ResponseEntity<List<Match>> expected = new ResponseEntity<>(matches, HttpStatus.OK);
        Mockito.when(repository.findAll()).thenReturn(matches);
        ResponseEntity<List<Match>> result = service.getAllGames();
        Assertions.assertTrue(expected.equals(result));
        Assertions.assertEquals(expected, result);
    }

    @Order(2)
    @Test
    void test_getAllCountries2(){
        List<Match> matches = Arrays.asList();
        ResponseEntity<List<Match>> expected = new ResponseEntity<>(matches, HttpStatus.NOT_FOUND);
        Mockito.when(repository.findAll()).thenReturn(matches);
        ResponseEntity<List<Match>> result = service.getAllGames();
        Assertions.assertTrue(expected.equals(result));
        Assertions.assertEquals(expected, result);
    }

    @Order(3)
    @Test
    void test_saveCountry(){
        Match expected = match2;
        Mockito.when(repository.save(match1)).thenReturn(match2);
        Match result = service.saveGame(match1);
        Assertions.assertTrue(expected.equals(result));
        Assertions.assertEquals(expected, result);
    }

    @Order(4)
    @Test
    void test_updateCountry(){
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(match2));
        Mockito.when(repository.save(match2)).thenReturn(match1);
        Match result = service.updateGame(1L, match1);
        Assertions.assertTrue(("cameroun").equals(result.getNom1()));
        Assertions.assertEquals("deutschland", result.getNom2());
    }

    @Order(4)
    @Test
    void test_updateCountry2(){
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(match2));
        Mockito.when(repository.save(match2)).thenReturn(match1);
        Match result = service.updateGame(1L, match1);
        Assertions.assertTrue(("cameroun").equals(result.getNom1()));
        Assertions.assertEquals("deutschland", result.getNom2());
    }

    @Order(5)
    @Test
    void test_getCountryById(){
        ResponseEntity<Match> expected =  new ResponseEntity<>(match1, HttpStatus.OK);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(match1));
        ResponseEntity<Match> result = service.getGameById(1L);
        Assertions.assertEquals(expected, result);
    }

    @Order(5)
    @Test
    void test_getCountryById2(){
        ResponseEntity<Match> expected =  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.empty());
        ResponseEntity<Match> result = service.getGameById(1L);
        Assertions.assertEquals(expected, result);
    }

}

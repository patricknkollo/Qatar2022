package com.qatar22.qatar22.servicestests;

import com.qatar22.qatar22.entities.Club;
import com.qatar22.qatar22.repositories.ClubRepository;
import com.qatar22.qatar22.services.ClubService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClubServiceTest {

    @InjectMocks
    private ClubService service;
    @Mock
    private ClubRepository repository;

    private Club club1 = new Club();
    private Club club2 = new Club();

    @BeforeAll
    void setup(){
        club1.setNom("chelsea");
        club1.setPays("UK");
        club1.setVille("london");
        club1.setPaysid(7L);
        club1.setClubid(1L);

        club2.setNom("barcelone");
        club2.setPays("UK");
        club2.setVille("london");
        club2.setPaysid(7L);
        club2.setClubid(1L);
    }

    @Order(1)
    @Test
    void test_getAllCountries(){
        List<Club> clubList = Arrays.asList(club1, club2);
        ResponseEntity<List<Club>> expected = new ResponseEntity<>(clubList, HttpStatus.OK);
        Mockito.when(repository.findAll()).thenReturn(clubList);
        ResponseEntity<List<Club>> result = service.getAllClubs();
        Assertions.assertTrue(expected.equals(result));
        Assertions.assertEquals(expected, result);
    }

    @Order(2)
    @Test
    void test_getAllCountries2(){
        List<Club> clubList = Arrays.asList();
        ResponseEntity<List<Club>> expected = new ResponseEntity<>(clubList, HttpStatus.NOT_FOUND);
        Mockito.when(repository.findAll()).thenReturn(clubList);
        ResponseEntity<List<Club>> result = service.getAllClubs();
        Assertions.assertTrue(expected.equals(result));
        Assertions.assertEquals(expected, result);
    }

    @Order(3)
    @Test
    void test_saveCountry(){
        Club expected = club2;
        Mockito.when(repository.save(club1)).thenReturn(club2);
        Club result = service.saveClub(club1);
        Assertions.assertTrue(expected.equals(result));
        Assertions.assertEquals(expected, result);
    }

    @Order(4)
    @Test
    void test_updateCountry(){
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(club2));
        Mockito.when(repository.save(club2)).thenReturn(club1);
        Club result = service.updateClub(1L, club1);
        Assertions.assertTrue(("chelsea").equals(result.getNom()));
    }

    @Order(5)
    @Test
    void test_updateCountry2(){
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(club2));
        Mockito.when(repository.save(club2)).thenReturn(club1);
        Club result = service.updateClub(1L, club1);
        Assertions.assertTrue(("chelsea").equals(result.getNom()));
    }

    @Order(6)
    @Test
    void test_getCountryById(){
        ResponseEntity<Club> expected =  new ResponseEntity<>(club1, HttpStatus.OK);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(club1));
        ResponseEntity<Club> result = service.getClubById(1L);
        Assertions.assertEquals(expected, result);
    }

    @Order(7)
    @Test
    void test_getCountryById2(){
        ResponseEntity<Club> expected =  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.empty());
        ResponseEntity<Club> result = service.getClubById(1L);
        Assertions.assertEquals(expected, result);
    }
}

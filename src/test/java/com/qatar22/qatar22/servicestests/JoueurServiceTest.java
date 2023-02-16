package com.qatar22.qatar22.servicestests;

import com.qatar22.qatar22.entities.Joueur;
import com.qatar22.qatar22.repositories.JoueurRepository;
import com.qatar22.qatar22.services.JoueurService;
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
public class JoueurServiceTest {

    @InjectMocks
    private JoueurService service;
    @Mock
    private JoueurRepository repository;

    private Joueur joueur1 = new Joueur();
    private Joueur joueur2 = new Joueur();

    @BeforeAll
    void setup(){
        joueur1.setDossard(10);
        joueur1.setNom("nkollo");
        joueur1.setPrenom("patrick");
        joueur1.setPersonid(1L);
        joueur1.setJoueurid(1L);

        joueur2.setDossard(11);
        joueur2.setNom("drogba");
        joueur2.setPrenom("didier");
        joueur2.setPersonid(2L);
        joueur2.setJoueurid(2L);
    }

    @Order(1)
    @Test
    void test_getAllCountries(){
        List<Joueur> joueurList = Arrays.asList(joueur1,joueur2);
        ResponseEntity<List<Joueur>> expected = new ResponseEntity<>(joueurList, HttpStatus.OK);
        Mockito.when(repository.findAll()).thenReturn(joueurList);
        ResponseEntity<List<Joueur>> result = service.getAllPlayers();
        Assertions.assertTrue(expected.equals(result));
        Assertions.assertEquals(expected, result);
    }

    @Order(2)
    @Test
    void test_getAllCountries2(){
        List<Joueur> joueurList = Arrays.asList();
        ResponseEntity<List<Joueur>> expected = new ResponseEntity<>(joueurList, HttpStatus.NOT_FOUND);
        Mockito.when(repository.findAll()).thenReturn(joueurList);
        ResponseEntity<List<Joueur>> result = service.getAllPlayers();
        Assertions.assertTrue(expected.equals(result));
        Assertions.assertEquals(expected, result);
    }

    @Order(3)
    @Test
    void test_saveCountry(){
        Joueur expected = joueur1;
        Mockito.when(repository.save(joueur1)).thenReturn(joueur1);
        Joueur result = service.saveJoueur(joueur1);
        Assertions.assertTrue(expected.equals(result));
        Assertions.assertEquals(expected, result);
    }

    @Order(4)
    @Test
    void test_updateCountry(){
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(joueur2));
        Mockito.when(repository.save(joueur2)).thenReturn(joueur1);
        Joueur result = service.updateJoueur(1L, joueur1);
        Assertions.assertTrue(("nkollo").equals(result.getNom()));
        Assertions.assertEquals(10, result.getDossard());
    }

    @Order(4)
    @Test
    void test_updateCountry2(){
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(joueur2));
        Mockito.when(repository.save(joueur2)).thenReturn(joueur1);
        Joueur result = service.updateJoueur(1L, joueur1);
        Assertions.assertTrue(("nkollo").equals(result.getNom()));
        Assertions.assertEquals(10, result.getDossard());
    }

    @Order(5)
    @Test
    void test_getCountryById(){
        ResponseEntity<Joueur> expected =  new ResponseEntity<>(joueur1, HttpStatus.OK);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(joueur1));
        ResponseEntity<Joueur> result = service.getJoueurById(1L);
        Assertions.assertEquals(expected, result);
    }

    @Order(5)
    @Test
    void test_getCountryById2(){
        ResponseEntity<Joueur> expected =  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.empty());
        ResponseEntity<Joueur> result = service.getJoueurById(1L);
        Assertions.assertEquals(expected, result);
    }

}

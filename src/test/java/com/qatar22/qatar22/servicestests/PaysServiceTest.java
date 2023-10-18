package com.qatar22.qatar22.servicestests;

import com.qatar22.qatar22.entities.Pays;
import com.qatar22.qatar22.repositories.PaysRepository;
import com.qatar22.qatar22.services.PaysService;
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
public class PaysServiceTest {

    @InjectMocks
    private PaysService paysService;
    @Mock
    private PaysRepository repository;

    private Pays pays1 = new Pays();
    private Pays pays2 = new Pays();

    @BeforeAll
    void setup(){
        pays1.setCdms(0);
        pays1.setNom("cameroun");
        pays1.setHabitants(30000000);
        pays1.setSuperficie(475000);
        pays1.setPaysid(1L);

        pays2.setCdms(4);
        pays2.setNom("deutschland");
        pays2.setHabitants(86000000);
        pays2.setSuperficie(375000);
        pays2.setPaysid(2L);
    }

    @Order(1)
    @Test
    void test_getAllCountries(){
        List<Pays> paysList = Arrays.asList(pays1,pays2);
        ResponseEntity<List<Pays>> expected = new ResponseEntity<>(paysList, HttpStatus.OK);
        Mockito.when(repository.findAll()).thenReturn(paysList);
        ResponseEntity<List<Pays>> result = paysService.getAllCountries();
        Assertions.assertTrue(expected.equals(result));
        Assertions.assertEquals(expected, result);
    }

    @Order(2)
    @Test
    void test_getAllCountries2(){
        List<Pays> paysList = Arrays.asList();
        ResponseEntity<List<Pays>> expected = new ResponseEntity<>(paysList, HttpStatus.NOT_FOUND);
        Mockito.when(repository.findAll()).thenReturn(paysList);
        ResponseEntity<List<Pays>> result = paysService.getAllCountries();
        Assertions.assertTrue(expected.equals(result));
        Assertions.assertEquals(expected, result);
    }

    @Order(3)
    @Test
    void test_saveCountry(){
        Pays expected = pays2;
        Mockito.when(repository.save(pays1)).thenReturn(pays2);
        Pays result = paysService.saveCountry(pays1);
        Assertions.assertTrue(expected.equals(result));
        Assertions.assertEquals(expected, result);
    }

    @Order(4)
    @Test
    void test_updateCountry(){
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(pays2));
        Mockito.when(repository.save(pays2)).thenReturn(pays1);
        Pays result = paysService.updateCountry(1L,pays1);
        Assertions.assertTrue(("cameroun").equals(result.getNom()));
        Assertions.assertEquals(0, result.getCdms());
    }

    @Order(5)
    @Test
    void test_updateCountry2(){
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(pays2));
        Mockito.when(repository.save(pays2)).thenReturn(pays1);
        Pays result = paysService.updateCountry(1L,pays1);
        Assertions.assertTrue(("cameroun").equals(result.getNom()));
        Assertions.assertEquals(0, result.getCdms());
    }

    @Order(6)
    @Test
    void test_getCountryById(){
        ResponseEntity<Pays> expected =  new ResponseEntity<>(pays1, HttpStatus.OK);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(pays1));
        ResponseEntity<Pays> result = paysService.getCountryById(1L);
        Assertions.assertEquals(expected, result);
    }

    @Order(7)
    @Test
    void test_getCountryById2(){
        ResponseEntity<Pays> expected =  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.empty());
        ResponseEntity<Pays> result = paysService.getCountryById(1L);
        Assertions.assertEquals(expected, result);
    }

}

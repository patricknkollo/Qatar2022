package com.qatar22.qatar22.servicestests;

import com.qatar22.qatar22.entities.Arbitre;
import com.qatar22.qatar22.repositories.ArbitreRepository;
import com.qatar22.qatar22.services.ArbitreService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArbitreServiceTest {

    @InjectMocks
    private ArbitreService service;

    @Mock
    private ArbitreRepository repository;

    private Arbitre arbitre1 = new Arbitre();
    private Arbitre arbitre2 = new Arbitre();

    @BeforeEach
    void setUp(){
        arbitre1.setNom("nkollo");
        arbitre1.setPersonid(1L);
        arbitre1.setPrenom("larry");
        arbitre1.setArbitreid(1L);

        arbitre1.setNom("mbappe");
        arbitre1.setPersonid(2L);
        arbitre1.setPrenom("kylian");
        arbitre1.setArbitreid(2L);
    }

    @Test
    @Order(1)
    void test_getAllreferees1(){
        ResponseEntity<List<Arbitre>> expected = new ResponseEntity<>(Arrays.asList(arbitre1, arbitre2), HttpStatus.OK);
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(arbitre1, arbitre2));
        ResponseEntity<List<Arbitre>> result = service.getAllreferees();
        Assertions.assertTrue(result.equals(expected));
    }

    @Test
    @Order(2)
    void test_getAllreferees2(){
        ResponseEntity<List<Arbitre>> expected = new ResponseEntity<>(Arrays.asList(), HttpStatus.NOT_FOUND);
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList());
        ResponseEntity<List<Arbitre>> result = service.getAllreferees();
        Assertions.assertTrue(result.equals(expected));
    }

    @Test
    @Order(3)
    void test_saveArbitre(){

    }


}

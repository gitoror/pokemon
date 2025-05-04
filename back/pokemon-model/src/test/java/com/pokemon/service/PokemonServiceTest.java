package com.pokemon.service;

import com.pokemon.model.City;
import com.pokemon.service.CityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
public class PokemonServiceTest {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16.0");

    @Autowired
    CityService cityService;

    @Test
    void ctxLoads() {}

    @Test
    void testCreateCityFromHere() {
        City citySaved = cityService.createCity("London");
        Assertions.assertEquals("London", citySaved.getName());
    }
}

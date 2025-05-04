package com.pokemon.repository;

import com.pokemon.TestConfig;
import com.pokemon.model.City;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(classes = {TestConfig.class})
@Testcontainers
public class CityRepositoryTest {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16.0");

    @Autowired
    CityRepository cityRepository;

    @Test
    void testCreateCity() {
        String name = "London";
        City city = City.builder()
                .name(name)
                .build();
        City savedCity = cityRepository.save(city);
        Assertions.assertEquals(name, savedCity.getName());

    }
}

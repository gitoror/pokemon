package com.pokemon.service;

import com.pokemon.model.City;
import com.pokemon.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CityService {
    private final CityRepository cityRepository;

    public City createCity(String name) {
        City city = City.builder()
                .name(name)
                .build();
        return cityRepository.save(city);
    }

    public City getCity(Long id) {
        return cityRepository.getReferenceById(id);
    }
}

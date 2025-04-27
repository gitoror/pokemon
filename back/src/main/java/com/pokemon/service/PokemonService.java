package com.pokemon.service;

import com.pokemon.model.Pokemon;
import com.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    public Pokemon getPokemonById(Long id) {
        return pokemonRepository.findById(id).orElseThrow(() -> new RuntimeException("Pokemon not found"));
    }

    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Pokemon updatePokemon(Long id, Pokemon pokemon) {
        Optional<Pokemon> existingPokemon = pokemonRepository.findById(id);
        if (existingPokemon.isPresent()) {
            
        }

    }

    public void deletePokemon(Long id) {
        pokemonRepository.deleteById(id);
    }

    public List<Pokemon> searchPokemon(String name) {
        return pokemonRepository.findByName(name);
    }
}

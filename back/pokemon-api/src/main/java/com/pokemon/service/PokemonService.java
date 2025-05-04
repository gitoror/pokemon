package com.pokemon.service;


import com.pokemon.model.Pokemon;
import com.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pokemon.exception.PokemonNotFoundException;

import java.util.List;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> getPokemons() {
        return pokemonRepository.findAll();
    }

    public Pokemon getPokemonById(Long id) {
        return pokemonRepository.findById(id).orElseThrow(() -> new PokemonNotFoundException("Pokemon not found"));
    }

    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Pokemon updatePokemon(Long id, Pokemon pokemon) {
        Pokemon existingPokemon = getPokemonById(id);
        existingPokemon.setName(pokemon.getName());
        existingPokemon.setHp(pokemon.getHp());
        return pokemonRepository.save(existingPokemon);
    }

    public void deletePokemon(Long id) {
        Pokemon existingPokemon = getPokemonById(id);
        pokemonRepository.deleteById(id);
    }
}

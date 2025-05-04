package com.pokemon.controller;

import com.pokemon.exception.PokemonNotFoundException;
import com.pokemon.model.Pokemon;
import com.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public ResponseEntity<List<Pokemon>> getPokemons() {
        return ResponseEntity.ok(pokemonService.getPokemons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable Long id) {
        return ResponseEntity.ok(pokemonService.getPokemonById(id));
    }

    @PostMapping
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pokemonService.createPokemon(pokemon));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pokemon> updatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        Pokemon updatedPokemon = pokemonService.updatePokemon(id, pokemon);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedPokemon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable Long id) {
        pokemonService.deletePokemon(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(PokemonNotFoundException.class)
    ResponseEntity<Void> handle(PokemonNotFoundException e) {
        return ResponseEntity.notFound().build();
    }
}

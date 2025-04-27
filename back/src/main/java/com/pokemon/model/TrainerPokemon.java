package com.pokemon.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "trainer_pokemon")
public class TrainerPokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;
}

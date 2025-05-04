package com.pokemon.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "pokemons")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer hp;
}

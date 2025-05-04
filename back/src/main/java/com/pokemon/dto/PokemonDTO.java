package com.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PokemonDTO {
    private Long id;
    private String name;
    private Integer hp;
}

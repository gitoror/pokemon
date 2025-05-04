create table pokemons (
    id bigserial,
    name varchar(255),
    hp int,
    constraint pk_pokemons primary key (id)
);
COMMENT ON TABLE pokemons IS 'Table de pokemons';
COMMENT ON COLUMN pokemons.name IS 'Nom du pokemon';

create table trainers (
    id bigserial,
    name varchar(255),
    age int,
    constraint pk_trainers primary key (id)
);

create table trainers_pokemon (
    id bigserial,
    trainer_id bigint,
    pokemon_id bigint,
    constraint pk_trainer_pokemon primary key (trainer_id, pokemon_id),
    constraint fk_trainer_pokemon_pokemon foreign key (pokemon_id) references pokemons(id) on delete cascade,
    constraint fk_trainer_pokemon_trainer foreign key (trainer_id) references trainers(id) on delete cascade
);




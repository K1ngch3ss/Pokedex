package org.example;

import java.util.Collection;
/**
 * Interface de uma PokeDex
 */
public interface PokedexInterface {
    /**
     * O método retorna o pokemon que teve seu nome pesquisado.
     * @throws PokemonInexistenteException caso não exista o pokemons no map de pokemons com o nome pesquisado.
     * @param nome
     * @return Pokemon
     */
    Pokemon pesquisaPokemon(String nome) throws PokemonInexistenteException;
    /**
     * O método adiciona um novo pokemon no Map de pokemons.
     * @param nome,atributo
     * @return boolean
     */
    boolean addPokemon(String nome,Atributo atributo);
    /**
     * O método remove o pokemon no Map de pokemons.
     * @param nome
     * @return boolean
     */
    boolean removePokemon(String nome);
    /**
     * O método retorna a lista com vantagens e desvantagens do atributo.
     * @param atributo
     * @return void
     */
    void pesquisaVantagensEDesvantagens(Atributo atributo);
    /**
     * O método retorna todos os pokemons colocados no Map de pokemons.
     * @return Collection<Pokemon>
     */
    Collection<Pokemon> verTodosPokemon();

}

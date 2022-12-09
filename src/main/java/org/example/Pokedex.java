package org.example;

import javax.swing.*;
import java.io.IOException;
import java.util.*;

public class Pokedex implements PokedexInterface {
    private Map<String,Pokemon> pokemons;
    GravadorDeDados gravador = new GravadorDeDados();
    public Pokedex(){
        try{
            this.pokemons = gravador.LeDado();
        }catch (IOException e){
            System.err.println(e.getMessage());
            this.pokemons = new HashMap<>();
        }
    }
    @Override
    public boolean addPokemon(String nome, Atributo atributo) {
        if(this.pokemons.containsKey(nome.toLowerCase())){
            return false;
        }
        this.pokemons.put(nome.toLowerCase(),new Pokemon(nome.toLowerCase(),atributo));
        return true;
    }
    public boolean addPokemon(String nome, Atributo atributo,Atributo atributo2) {
        if(this.pokemons.containsKey(nome.toLowerCase())){
            return false;
        }
        this.pokemons.put(nome.toLowerCase(),new Pokemon(nome.toLowerCase(),atributo,atributo2));
        return true;
    }

    @Override
    public boolean removePokemon(String nome){
        if(this.pokemons.containsKey(nome.toLowerCase())){
            this.pokemons.remove(nome);
            return true;
        }
        return false;
    }
    @Override
    public Pokemon pesquisaPokemon(String nome) throws PokemonInexistenteException{
        if(this.pokemons.containsKey(nome.toLowerCase())){
            return pokemons.get(nome);
        }
        throw new PokemonInexistenteException("Pokemon não cadastrado.");

    }
    @Override
    public void pesquisaVantagensEDesvantagens(Atributo atributo) {
        JOptionPane.showMessageDialog(null,"Vantagens:"+vantagens(atributo)+"\nDesvantagens:"+desvantagens(atributo));
    }

    public void sairDoSistema(){
        try{
            this.gravador.gravaDado(this.pokemons);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
    @Override
    public Collection<Pokemon> verTodosPokemon() {
        return this.pokemons.values();
    }

    public Collection<Atributo> vantagens(Atributo atributo){
        List<Atributo> vantagensA = new ArrayList<Atributo>();
        if (atributo.equals(Atributo.FOGO)) {
            vantagensA.add(Atributo.INSETO);
            vantagensA.add(Atributo.METAL);
            vantagensA.add(Atributo.PLANTA);
            vantagensA.add(Atributo.GELO);
        } else if (atributo.equals(Atributo.LUTADOR)) {
            vantagensA.add(Atributo.NORMAL);
            vantagensA.add(Atributo.PEDRA);
            vantagensA.add(Atributo.GELO);
            vantagensA.add(Atributo.SOMBRIO);
        } else if (atributo.equals(Atributo.VOADOR)) {
            vantagensA.add(Atributo.LUTADOR);
            vantagensA.add(Atributo.INSETO);
            vantagensA.add(Atributo.PLANTA);
        } else if (atributo.equals(Atributo.VENENO)) {
            vantagensA.add(Atributo.PLANTA);
            vantagensA.add(Atributo.FADA);
        } else if (atributo.equals(Atributo.TERRA)) {
            vantagensA.add(Atributo.VENENO);
            vantagensA.add(Atributo.PEDRA);
            vantagensA.add(Atributo.METAL);
            vantagensA.add(Atributo.FOGO);
            vantagensA.add(Atributo.ELETRICO);
        } else if (atributo.equals(Atributo.PEDRA)) {
            vantagensA.add(Atributo.VOADOR);
            vantagensA.add(Atributo.FOGO);
            vantagensA.add(Atributo.GELO);
        } else if (atributo.equals(Atributo.INSETO)) {
            vantagensA.add(Atributo.PLANTA);
            vantagensA.add(Atributo.PSIQUICO);
            vantagensA.add(Atributo.SOMBRIO);
        } else if (atributo.equals(Atributo.FANTASMA)) {
            vantagensA.add(Atributo.FANTASMA);
            vantagensA.add(Atributo.PSIQUICO);
        } else if (atributo.equals(Atributo.METAL)) {
            vantagensA.add(Atributo.PEDRA);
            vantagensA.add(Atributo.GELO);
            vantagensA.add(Atributo.FADA);
        } else if (atributo.equals(Atributo.AGUA)) {
            vantagensA.add(Atributo.TERRA);
            vantagensA.add(Atributo.PEDRA);
            vantagensA.add(Atributo.FOGO);
        } else if (atributo.equals(Atributo.PLANTA)) {
            vantagensA.add(Atributo.TERRA);
            vantagensA.add(Atributo.PEDRA);
            vantagensA.add(Atributo.AGUA);
        } else if (atributo.equals(Atributo.ELETRICO)) {
            vantagensA.add(Atributo.VOADOR);
            vantagensA.add(Atributo.AGUA);
        } else if (atributo.equals(Atributo.PSIQUICO)) {
            vantagensA.add(Atributo.LUTADOR);
            vantagensA.add(Atributo.VENENO);
        } else if (atributo.equals(Atributo.GELO)) {
            vantagensA.add(Atributo.VOADOR);
            vantagensA.add(Atributo.TERRA);
            vantagensA.add(Atributo.PLANTA);
            vantagensA.add(Atributo.DRAGAO);
        } else if (atributo.equals(Atributo.DRAGAO)) {
            vantagensA.add(Atributo.DRAGAO);
        } else if (atributo.equals(Atributo.SOMBRIO)) {
            vantagensA.add(Atributo.FANTASMA);
            vantagensA.add(Atributo.PSIQUICO);
        } else if (atributo.equals(Atributo.FADA)) {
            vantagensA.add(Atributo.LUTADOR);
            vantagensA.add(Atributo.DRAGAO);
            vantagensA.add(Atributo.SOMBRIO);
        }
        return vantagensA;
    }

    public Collection<Atributo> desvantagens(Atributo atributo){
        List<Atributo> desvantagensA = new ArrayList<Atributo>();
        if (atributo.equals(Atributo.NORMAL)) {
            desvantagensA.add(Atributo.PEDRA);
            desvantagensA.add(Atributo.METAL);
            desvantagensA.add(Atributo.FANTASMA);
        } else if (atributo.equals(Atributo.FOGO)) {
            desvantagensA.add(Atributo.FOGO);
            desvantagensA.add(Atributo.PEDRA);
            desvantagensA.add(Atributo.AGUA);
            desvantagensA.add(Atributo.DRAGAO);
        } else if (atributo.equals(Atributo.LUTADOR)) {
            desvantagensA.add(Atributo.VOADOR);
            desvantagensA.add(Atributo.VENENO);
            desvantagensA.add(Atributo.INSETO);
            desvantagensA.add(Atributo.PSIQUICO);
            desvantagensA.add(Atributo.FADA);
        } else if (atributo.equals(Atributo.VOADOR)) {
            desvantagensA.add(Atributo.PEDRA);
            desvantagensA.add(Atributo.METAL);
            desvantagensA.add(Atributo.ELETRICO);
        } else if (atributo.equals(Atributo.VENENO)) {
            desvantagensA.add(Atributo.VENENO);
            desvantagensA.add(Atributo.TERRA);
            desvantagensA.add(Atributo.PEDRA);
            desvantagensA.add(Atributo.FANTASMA);
            desvantagensA.add(Atributo.METAL);
        } else if (atributo.equals(Atributo.TERRA)) {
            desvantagensA.add(Atributo.VOADOR);
            desvantagensA.add(Atributo.INSETO);
            desvantagensA.add(Atributo.PLANTA);
        } else if (atributo.equals(Atributo.PEDRA)) {
            desvantagensA.add(Atributo.LUTADOR);
            desvantagensA.add(Atributo.TERRA);
            desvantagensA.add(Atributo.METAL);
        } else if (atributo.equals(Atributo.INSETO)) {
            desvantagensA.add(Atributo.LUTADOR);
            desvantagensA.add(Atributo.VOADOR);
            desvantagensA.add(Atributo.VENENO);
            desvantagensA.add(Atributo.FANTASMA);
            desvantagensA.add(Atributo.METAL);
            desvantagensA.add(Atributo.FOGO);
            desvantagensA.add(Atributo.FADA);
        } else if (atributo.equals(Atributo.FANTASMA)) {
            desvantagensA.add(Atributo.NORMAL);
            desvantagensA.add(Atributo.SOMBRIO);
        } else if (atributo.equals(Atributo.METAL)) {
            desvantagensA.add(Atributo.METAL);
            desvantagensA.add(Atributo.FOGO);
            desvantagensA.add(Atributo.AGUA);
            desvantagensA.add(Atributo.ELETRICO);
        } else if (atributo.equals(Atributo.AGUA)) {
            desvantagensA.add(Atributo.AGUA);
            desvantagensA.add(Atributo.PLANTA);
            desvantagensA.add(Atributo.DRAGAO);
        } else if (atributo.equals(Atributo.PLANTA)) {
            desvantagensA.add(Atributo.VOADOR);
            desvantagensA.add(Atributo.VENENO);
            desvantagensA.add(Atributo.INSETO);
            desvantagensA.add(Atributo.METAL);
            desvantagensA.add(Atributo.FOGO);
            desvantagensA.add(Atributo.PLANTA);
            desvantagensA.add(Atributo.DRAGAO);
        } else if (atributo.equals(Atributo.ELETRICO)) {
            desvantagensA.add(Atributo.TERRA);
            desvantagensA.add(Atributo.PLANTA);
            desvantagensA.add(Atributo.ELETRICO);
            desvantagensA.add(Atributo.DRAGAO);
        } else if (atributo.equals(Atributo.PSIQUICO)) {
            desvantagensA.add(Atributo.METAL);
            desvantagensA.add(Atributo.PSIQUICO);
            desvantagensA.add(Atributo.SOMBRIO);
        } else if (atributo.equals(Atributo.GELO)) {
            desvantagensA.add(Atributo.METAL);
            desvantagensA.add(Atributo.FOGO);
            desvantagensA.add(Atributo.AGUA);
            desvantagensA.add(Atributo.GELO);
        } else if (atributo.equals(Atributo.DRAGAO)) {
            desvantagensA.add(Atributo.METAL);
            desvantagensA.add(Atributo.FADA);
        } else if (atributo.equals(Atributo.SOMBRIO)) {
            desvantagensA.add(Atributo.LUTADOR);
            desvantagensA.add(Atributo.SOMBRIO);
            desvantagensA.add(Atributo.FADA);
        } else if (atributo.equals(Atributo.FADA)) {
            desvantagensA.add(Atributo.VENENO);
            desvantagensA.add(Atributo.METAL);
            desvantagensA.add(Atributo.FOGO);
        }
        return desvantagensA;
    }
}

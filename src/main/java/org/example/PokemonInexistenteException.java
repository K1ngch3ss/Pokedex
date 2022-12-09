package org.example;

public class PokemonInexistenteException extends Exception{
    public PokemonInexistenteException(String msg){
        super(msg);
    }
}

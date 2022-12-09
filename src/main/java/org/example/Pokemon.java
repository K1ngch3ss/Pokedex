package org.example;

import java.io.Serializable;

public class Pokemon implements Serializable {

    private String nome;
    private Atributo atributo;

    private Atributo atributo2;

    public Pokemon(String nome,Atributo atributo){
        this.nome = nome;
        this.atributo = atributo;
        this.atributo2 = Atributo.SEM;
    }
    public Pokemon(String nome,Atributo atributo,Atributo atributo2){
        this.nome = nome;
        this.atributo = atributo;
        this.atributo2 = atributo2;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }
    public Atributo getAtributo2() {
        return atributo2;
    }

    public void setAtributo2(Atributo atributo) {
        this.atributo = atributo2;
    }

    public String toString(){
        return "Pokemon:"+ this.nome+" e Atributo(s):"+this.atributo+", "+this.atributo2;
    }
}

package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokedexAddController implements ActionListener {
    private Pokedex pokedex;
    private JFrame janela;
    public PokedexAddController(Pokedex pokedex, JFrame janela){
        this.pokedex = pokedex;
        this.janela = janela;
    }
    public void actionPerformed(ActionEvent e){
        String nome = JOptionPane.showInputDialog(janela,"Qual é o nome do Pokemon:").toLowerCase();
        Object[] itens = { Atributo.SEM,Atributo.FOGO,Atributo.AGUA,Atributo.PLANTA,Atributo.VOADOR,
                Atributo.LUTADOR,Atributo.VENENO,Atributo.ELETRICO, Atributo.TERRA,Atributo.PEDRA,
                Atributo.PSIQUICO,Atributo.GELO,Atributo.INSETO,Atributo.FANTASMA, Atributo.METAL,
                Atributo.DRAGAO,Atributo.SOMBRIO,Atributo.FADA,Atributo.NORMAL};
        Object atributo = JOptionPane.showInputDialog(janela,
                "Escolha um atributo", "Opçao",
                JOptionPane.INFORMATION_MESSAGE, null,
                itens, itens [0]);
        Object[] itens2 = { Atributo.SEM,Atributo.FOGO,Atributo.AGUA,Atributo.PLANTA,Atributo.VOADOR,
                Atributo.LUTADOR,Atributo.VENENO,Atributo.ELETRICO, Atributo.TERRA,Atributo.PEDRA,
                Atributo.PSIQUICO,Atributo.GELO,Atributo.INSETO,Atributo.FANTASMA, Atributo.METAL,
                Atributo.DRAGAO,Atributo.SOMBRIO,Atributo.FADA,Atributo.NORMAL};
        Object atributo2 = JOptionPane.showInputDialog(janela,
                "Escolha um atributo", "Opçao",
                JOptionPane.INFORMATION_MESSAGE, null,
                itens, itens [0]);
        if(pokedex.addPokemon(nome, (Atributo) atributo,(Atributo) atributo2)){
            JOptionPane.showMessageDialog(janela,"Pokemon adicionado com sucesso!");
        }else{
            JOptionPane.showMessageDialog(janela,"Pokemon já adicionado");
        }
        pokedex.sairDoSistema();
    }
}

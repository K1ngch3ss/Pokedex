package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class PokedexPesquisaController implements ActionListener {
    private Pokedex pokedex;
    private JFrame janela;
    public PokedexPesquisaController(Pokedex pokedex,JFrame janela){
        this.pokedex = pokedex;
        this.janela = janela;
    }
    public void actionPerformed(ActionEvent e){
        String nome = JOptionPane.showInputDialog(janela,"Qual é o nome:").toLowerCase();
        try {
            Pokemon pokemon = pokedex.pesquisaPokemon(nome);
            JOptionPane.showMessageDialog(janela,pokemon);
        }catch (PokemonInexistenteException a){
            JOptionPane.showMessageDialog(janela,a.getMessage());
        }
    }
}

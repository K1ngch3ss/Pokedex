package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokedexVerTodosController implements ActionListener {
    private Pokedex pokedex;
    private JFrame janela;
    public PokedexVerTodosController(Pokedex pokedex, JFrame janela){
        this.pokedex = pokedex;
        this.janela = janela;
    }
    public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(janela,pokedex.verTodosPokemon());
    }

}

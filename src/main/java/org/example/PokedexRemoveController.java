package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokedexRemoveController implements ActionListener {
    private Pokedex pokedex;
    private JFrame janela;
    public PokedexRemoveController(Pokedex pokedex,JFrame janela){
        this.pokedex = pokedex;
        this.janela = janela;

    }
    public void actionPerformed(ActionEvent e){
        String nome = JOptionPane.showInputDialog(janela,"Qual é o nome do Pokemon:").toLowerCase();
        if(pokedex.removePokemon(nome)){
            JOptionPane.showMessageDialog(janela,"Pokemon Removido com sucesso");
        }else{
            JOptionPane.showMessageDialog(janela,"Erro ao remover Pokemon");
        }
        pokedex.sairDoSistema();
    }
}

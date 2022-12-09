package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokedexPesquisaVantagensController implements ActionListener {
    private Pokedex  pokedex;
    private JFrame  janela;
    public PokedexPesquisaVantagensController(Pokedex pokedex, JFrame janela){
        this.pokedex = pokedex;
        this.janela = janela;
    }
    public void actionPerformed(ActionEvent e){
        Object[] itens = { Atributo.SEM,Atributo.FOGO,Atributo.AGUA,Atributo.PLANTA,Atributo.VOADOR,
                Atributo.LUTADOR,Atributo.VENENO,Atributo.ELETRICO, Atributo.TERRA,Atributo.PEDRA,
                Atributo.PSIQUICO,Atributo.GELO,Atributo.INSETO,Atributo.FANTASMA, Atributo.METAL,
                Atributo.DRAGAO,Atributo.SOMBRIO,Atributo.FADA,Atributo.NORMAL};
        Object atributo = JOptionPane.showInputDialog(janela,
                "Escolha um atributo", "Opçao",
                JOptionPane.INFORMATION_MESSAGE, null,
                itens, itens [0]);
        pokedex.pesquisaVantagensEDesvantagens((Atributo) atributo);
    }
}

package org.example;

import javax.imageio.ImageIO;
import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class PokedexGUI extends JFrame {
    JLabel linha1,linha2;
    ImageIcon pesquisa = new ImageIcon("./imgs/pesquisar.png");
    ImageIcon add = new ImageIcon("./imgs/add.png");
    ImageIcon cima = new ImageIcon("./imgs/cimaPokedex.png");
    ImageIcon baixo = new ImageIcon("./imgs/baixoPokedex.png");
    JButton botaoAdd,botaoPesquisar;
    JMenuBar  barraDeMenu = new JMenuBar();
    Pokedex pokedex = new Pokedex();
    public PokedexGUI(){
        setSize(615,585);
        setLocation(150,150);
        setResizable(false);
        linha1 = new JLabel(cima,JLabel.CENTER);
        linha2 = new JLabel(baixo,JLabel.CENTER);
        botaoAdd = new JButton(add);
        botaoAdd.addActionListener(new PokedexAddController(pokedex,this));
        botaoPesquisar = new JButton(pesquisa);
        botaoPesquisar.addActionListener(new PokedexPesquisaController(pokedex,this));
        setLayout(new GridLayout(2,1));
        add(linha1);
        add(botaoPesquisar);
        add(linha2);
        add(botaoAdd);
        JMenu menuPrincipaisF = new JMenu("Funções");
        JMenuItem menuPesquisar = new JMenuItem("Pesquisar Pokemon");
        menuPesquisar.addActionListener(new PokedexPesquisaController(pokedex,this));
        JMenuItem menuAdd = new JMenuItem("Adicionar Pokemon");
        menuAdd.addActionListener(new PokedexAddController(pokedex,this));
        JMenuItem menuVerTodos = new JMenuItem("Ver todos os Pokemons cadastrados");
        menuVerTodos.addActionListener(new PokedexVerTodosController(pokedex,this));
        JMenuItem menuRemover = new JMenuItem("Remover Pokemon");
        menuRemover.addActionListener(new PokedexRemoveController(pokedex,this));
        menuPrincipaisF.add(menuPesquisar);
        menuPrincipaisF.add(menuAdd);
        menuPrincipaisF.add(menuVerTodos);
        menuPrincipaisF.add(menuRemover);
        JMenu menuCombate = new JMenu("Funções de combate");
        JMenuItem menuPesquisaVantagens = new JMenuItem("Pesquisar vantagens e desvantagens");
        menuPesquisaVantagens.addActionListener(new PokedexPesquisaVantagensController(pokedex,this));
        menuCombate.add(menuPesquisaVantagens);
        barraDeMenu.add(menuPrincipaisF);
        barraDeMenu.add(menuCombate);
        setJMenuBar(barraDeMenu);
    }

    public static void main(String[] args) {
        JFrame janela = new PokedexGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

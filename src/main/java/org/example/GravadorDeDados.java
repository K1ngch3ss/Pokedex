package org.example;

import java.io.*;
import java.util.Map;

public class GravadorDeDados {
    public Map<String,Pokemon> LeDado() throws IOException{
        ObjectInputStream entrada = null;
        try{
            entrada = new ObjectInputStream(new FileInputStream("pokemons.txt"));
            return (Map<String,Pokemon>) entrada.readObject();
        }catch (FileNotFoundException e){
            throw new IOException("Erro ao recuperar arquivo",e);
        }catch (IOException e){
            throw e;
        }catch (ClassNotFoundException e){
            throw new IOException("Classe dos objetos gravados no arquivo"+"pokemons.txt não existe", e);
        }finally {
            if(entrada!= null){
                entrada.close();
            }
        }
    }
    public void gravaDado(Map<String,Pokemon> pokemons)throws IOException{
        ObjectOutputStream saida = null;
        try{
            saida = new ObjectOutputStream(new FileOutputStream("pokemons.txt"));
            saida.writeObject(pokemons);
        }catch (FileNotFoundException e){
            throw new IOException("Erro ao salvar dados",e);
        }catch (IOException e){
            throw e;
        }finally {
            if(saida != null){
                saida.close();
            }
        }
    }
}

import org.example.Atributo;
import org.example.Pokedex;
import org.example.PokemonInexistenteException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.*;

public class PokedexTest {
    Pokedex pokeDex = new Pokedex();
    @Test
    public void TestaAddERemovePokemon(){
        assertTrue(pokeDex.addPokemon("minUn",Atributo.ELETRICO));
        assertFalse(pokeDex.addPokemon("minun",Atributo.ELETRICO));
        assertTrue(pokeDex.removePokemon("minun"));
        assertFalse(pokeDex.removePokemon("minun"));
    }
    @Test
    public void TestaPesquisaPokemon(){
        pokeDex.addPokemon("minun", Atributo.ELETRICO);
        try{
            pokeDex.pesquisaPokemon("mInun");
        }catch (PokemonInexistenteException e){
            fail("Não deveria lançar essa Exceção");
        }
    }
    @Test
    public void TestaVerTodosPokemons(){
        pokeDex.addPokemon("minun", Atributo.ELETRICO);
        assertEquals(pokeDex.verTodosPokemon().size(),1);
    }
    @Test
    public void TestaVantagensEDesvantagens(){
        Atributo dragao = Atributo.DRAGAO;
        List<Atributo> vantagens = new ArrayList<>();
        vantagens.add(dragao);
        List<Atributo> desvantagens = new ArrayList<>();
        desvantagens.add(Atributo.METAL);
        desvantagens.add(Atributo.FADA);
        assertEquals(pokeDex.vantagens(Atributo.DRAGAO), vantagens);
        assertEquals(pokeDex.desvantagens(Atributo.DRAGAO), desvantagens);
    }

}

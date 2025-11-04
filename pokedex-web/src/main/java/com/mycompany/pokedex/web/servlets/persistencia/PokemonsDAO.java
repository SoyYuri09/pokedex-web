package com.mycompany.pokedex.web.servlets.persistencia;
import com.mycompany.pokedex.web.servlets.dominio.PokemonDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * @author Yuri Germán García López - 252583
 */
public class PokemonsDAO implements IPokemonsDAO {

    private static final List<PokemonDTO> listaPokemons = Collections.synchronizedList(
        new ArrayList<>(
            Arrays.asList(
                new PokemonDTO("Zeraora", 807, "Eléctrico", "imgs/zeraora.png"),
                new PokemonDTO("Meowscarada", 908, "Planta/Siniestro", "imgs/meowscarada.png"),
                new PokemonDTO("Lucario", 448, "Lucha/Acero", "imgs/lucario.png"),
                new PokemonDTO("Zoroark", 571, "Siniestro", "imgs/zoroark.png"),
                new PokemonDTO("Lycanroc", 744, "Roca", "imgs/lycanroc.png"),
                new PokemonDTO("Gardevoir", 282, "Psíquico/Hada", "imgs/gardevoir.png"),
                new PokemonDTO("Meowstic", 678, "Psíquico", "imgs/meowstic.png")
            )
        )
    );

    @Override
    public List<PokemonDTO> obtenerNuevosPokemons() {
        return listaPokemons;
    }

    @Override
    public void agregarPokemon(PokemonDTO pokemon) {
        listaPokemons.add(pokemon);
    }
    
}
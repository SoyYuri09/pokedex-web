package com.mycompany.pokedex.web.servlets.persistencia;
import com.mycompany.pokedex.web.servlets.dominio.PokemonDTO;
import java.util.List;
/**
 * @author Yuri Germán García López - 252583
 */
public interface IPokemonsDAO {
    public List<PokemonDTO> obtenerNuevosPokemons();
    public void agregarPokemon(PokemonDTO pokemon);
}

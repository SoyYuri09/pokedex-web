package com.mycompany.pokedex.web.servlets.dominio;
/**
 * @author Yuri Germán García López - 252583
 */
public class PokemonDTO {
    private String nombre;
    private int numero;
    private String tipo;
    private String url;

    public PokemonDTO(String nombre, int numero, String tipo, String url) {
        this.nombre = nombre;
        this.numero = numero;
        this.tipo = tipo;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUrl() {
        return url;
    }
    
}
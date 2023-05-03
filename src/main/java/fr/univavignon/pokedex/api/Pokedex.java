package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{
	
	List<Pokemon> pokemonList = new ArrayList<Pokemon>();
	IPokemonMetadataProvider pokemonMetadataProvider;
	IPokemonFactory pokemonFactory;
	
	public Pokedex(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory){
		this.pokemonMetadataProvider = pokemonMetadataProvider;
		this.pokemonFactory = pokemonFactory;
	}

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		pokemonMetadataProvider.getPokemonMetadata(index);
		return null;
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		pokemonFactory.createPokemon(index, cp, hp, dust, candy);
		return null;
	}

	@Override
	public int size() {
		return pokemonList.size();
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		pokemonList.add(pokemon);
		return pokemon.getIndex();
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		for (Pokemon pokemon : pokemonList) {
	        if (pokemon.getIndex() == id) {
	            return pokemon;
	        }
	    }
	    return null;
	}

	@Override
	public List<Pokemon> getPokemons() {
		return pokemonList;
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		List<Pokemon> orderedPokemonList = getPokemons();
		Collections.sort(orderedPokemonList, order);
		return null;
	}

}
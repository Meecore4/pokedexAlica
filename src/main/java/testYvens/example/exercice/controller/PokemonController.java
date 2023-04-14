package testYvens.example.exercice.controller;

import org.apache.tomcat.util.net.NioEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testYvens.example.exercice.entity.Pokemon;
import testYvens.example.exercice.repository.PokemonRepository;

import java.util.List;

@RestController
@CrossOrigin
public class PokemonController {

    @Autowired
    PokemonRepository pokemonRepository;


   // 1. Post qui rentre le nom, et type du pokemon (Feu, air, water, shadow)
   @PostMapping("/pokemon")
   public Pokemon addPokemon(@RequestBody Pokemon pokemon){
       pokemonRepository.save(pokemon);
       return pokemon;
   }

    // 2.Get qui renvoie tous les pokemon
    @GetMapping("/listPokemons")
    public List<Pokemon> getPokemons(){
        return pokemonRepository.findAll();
    }

    //3.Get qui renvoie une pokémon  par son nom
    @GetMapping("/vasurtonchemin/{name}")
    public Pokemon getPokemonByName(@PathVariable String name){
    return pokemonRepository.findByName(name);
    }


    //4.Put qui permet de modifier le nom du pokémon
    @PutMapping("/modifPokemon/{name}")
    public Pokemon modifPokemon(@PathVariable String name, @RequestBody Pokemon pokemon) {
        Pokemon modifier = pokemonRepository.findByName(name);
        modifier.setName(pokemon.getName());
        pokemonRepository.save(pokemon);
        return modifier;

    }
    //5. Delete qui permet de supprimer le pokemon
    @DeleteMapping("/supprimerPokemon/{id}")
    public void supprimerPokemon(@PathVariable Long id){
    pokemonRepository.deleteById(id);
    }
    }






package pokemon.view.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.view.backend.Model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon,Long> {
    public boolean exitsByName(String name);
    
    
}

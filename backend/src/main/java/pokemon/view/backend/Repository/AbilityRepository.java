package pokemon.view.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.view.backend.Model.Ability;

public interface AbilityRepository extends JpaRepository<Ability,Long>{
    
}

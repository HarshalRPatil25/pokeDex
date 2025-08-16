package pokemon.view.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.view.backend.Model.Stats;

public interface StatsRepository extends JpaRepository<Stats,Long> {
    
}

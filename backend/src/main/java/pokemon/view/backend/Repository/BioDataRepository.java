package pokemon.view.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.view.backend.Model.BioData;

public interface BioDataRepository extends JpaRepository<BioData,Long> {
    
}

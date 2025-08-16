package pokemon.view.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pokemon.view.backend.Model.Image;

public interface ImageRepository extends JpaRepository<Image,Long> {
    
}

package pokemon.view.backend.DTO;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Component
public class PokemonDTO {
       @Min(1)
    @Column(name = "pokedex_number", nullable = false)
    private Integer pokedexNumber;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String name;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Integer generation;
}

package pokemon.view.backend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.*;

@Entity
@Table(
  name = "pokemon",
  uniqueConstraints = @UniqueConstraint(name = "uk_pokemon_pokedex_number", columnNames = "pokedex_number")
)
@Getter @Setter @NoArgsConstructor
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    // simple array of types; you can normalize if you need type tables
    @ElementCollection
    @CollectionTable(name = "pokemon_types", joinColumns = @JoinColumn(name = "pokemon_id"))
    @Column(name = "type", nullable = false, length = 30)
    private Set<String> types = new LinkedHashSet<>();

    // One-to-one owned by Pokemon; cascade for easy create/update
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "bio_data_id", unique = true)
    private BioData bioData;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "stats_id", unique = true)
    private Stats stats;

    // Many-to-many via join table
    @ManyToMany
    @JoinTable(
        name = "pokemon_abilities",
        joinColumns = @JoinColumn(name = "pokemon_id"),
        inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    private Set<Ability> abilities = new LinkedHashSet<>();

    // One-to-many images; Image holds FK
    @OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();

    // cached like counter (optional; true source should be user_likes table)
    @Column(name = "like_count", nullable = false)
    private Long likeCount = 0L;
}

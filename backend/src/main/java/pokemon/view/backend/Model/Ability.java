package pokemon.view.backend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "abilities")
@Getter @Setter @NoArgsConstructor
public class Ability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "hidden", nullable = false)
    private boolean hidden = false;

    // reverse side (optional)
    @ManyToMany(mappedBy = "abilities")
    private Set<Pokemon> pokemon = new HashSet<>();
}

package pokemon.view.backend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "stats")
@Getter @Setter @NoArgsConstructor
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @Min(1)  @Column(nullable = false) private Integer hp;
    @NotNull @Min(1)  @Column(nullable = false) private Integer attack;
    @NotNull @Min(1)  @Column(nullable = false) private Integer defense;
    @NotNull @Min(1)  @Column(name="special_attack", nullable = false) private Integer specialAttack;
    @NotNull @Min(1)  @Column(name="special_defense", nullable = false) private Integer specialDefense;
    @NotNull @Min(1)  @Column(nullable = false) private Integer speed;
}

package pokemon.view.backend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "bio_data")
@Getter @Setter @NoArgsConstructor
public class BioData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // meters / kilograms often need decimals
    @NotNull
    @DecimalMin("0.1")
    @Column(name = "height_m", nullable = false)
    private Double heightM;

    @NotNull
    @DecimalMin("0.1")
    @Column(name = "weight_kg", nullable = false)
    private Double weightKg;

    @NotNull
    @Min(0)
    @Column(name = "capture_rate", nullable = false)
    private Integer captureRate;

    @NotNull
    @Min(0)
    @Column(name = "base_friendship", nullable = false)
    private Integer baseFriendship = 50;

    @NotNull
    @Min(0)
    @Column(name = "base_experience", nullable = false)
    private Integer baseExperience = 0;
}

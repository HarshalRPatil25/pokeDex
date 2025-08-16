package pokemon.view.backend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "images")
@Getter @Setter @NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "sprite_url", nullable = false, length = 512)
    private String spriteUrl;

    @NotBlank
    @Column(name = "official_art_url", nullable = false, length = 512)
    private String officialArtUrl;

    @Column(name = "shiny_sprite_url", length = 512)
    private String shinySpriteUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemon_id", nullable = false)
    private Pokemon pokemon;
}

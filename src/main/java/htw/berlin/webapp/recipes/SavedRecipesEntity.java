package htw.berlin.webapp.recipes;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "saved_recipes")

public class SavedRecipesEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "saving", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Saving saving;

    protected SavedRecipesEntity() {}

    public SavedRecipesEntity(String name, Saving saving) {
        this.name = name;
        this.saving = saving;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Saving getSaving() {
        return saving;
    }

    public void setSaving(Saving saving) {
        this.saving = saving;
    }
}


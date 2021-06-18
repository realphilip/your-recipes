package htw.berlin.webapp;

import javax.persistence.*;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String name;
    private  String ingredients;
    private  String instructions;

    public Recipe(){
    }

    public Recipe(Long id, String name, String ingredients, String instructions) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() { return ingredients; }

    public String getInstructions() { return instructions; }
}

package htw.berlin.webapp;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    @ElementCollection
    private  ArrayList<String> ingredients;
    @ElementCollection
    private  ArrayList<String> instructions;

    public Recipe(){
    }

    public Recipe(Long id, String name, ArrayList<String> ingredients, ArrayList<String> instructions) {
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

    public ArrayList<String> getIngredients() { return ingredients; }

    public ArrayList<String> getInstructions() { return instructions; }
}

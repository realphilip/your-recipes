package htw.berlin.webapp.api;

import java.util.ArrayList;

public class Recipe {

    private final Long id;
    private final String name;
    private final ArrayList<String> ingredients;
    private final ArrayList<String> instructions;

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

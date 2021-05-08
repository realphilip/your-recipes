package htw.berlin.webapp.api;

public class Recipe {

    private final Long id;
    private final String name;
    private final String ingredients;
    private final String instructions;

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

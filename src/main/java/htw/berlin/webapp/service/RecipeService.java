package htw.berlin.webapp.service;


import java.util.List;

public interface RecipeService {
//
    void saveRecipe(RecipeSavingRequest Recipe);

    List<User> fetchAllSavedRecipes();

}

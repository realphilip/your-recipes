package htw.berlin.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RecipeService {

    @Autowired
    public RecipeRepository recipeRepository;

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteById(Long recipeToDeleteId) {
        recipeRepository.deleteById(recipeToDeleteId);
    }

    public ArrayList<Recipe> getAllRecipesAsList() {
        ArrayList<Recipe> allRecipesAsList = new ArrayList<>();
        var repositoryContent = recipeRepository.findAll();
        for (Recipe i : repositoryContent) {
            allRecipesAsList.add(i);
            }
            return allRecipesAsList;

    }
    }


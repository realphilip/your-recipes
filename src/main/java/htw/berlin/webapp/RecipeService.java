package htw.berlin.webapp;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public void addRecipe(Recipe recipe){
        recipeRepository.save(recipe);
    }

    public void deleteById(Long recipeToDeleteId){
        recipeRepository.deleteById(recipeToDeleteId);
    }

    public ArrayList<Recipe> getAllRecipesAsList(){
        ArrayList allRecipesAsList = new ArrayList<Recipe>();
        var repositoryContent = recipeRepository.findAll();
        repositoryContent.forEach(allRecipesAsList:: add);
        return allRecipesAsList;
    }

    public Long countRecipesInRepo(){
        return recipeRepository.count();
    }
}

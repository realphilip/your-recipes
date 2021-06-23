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

    public ArrayList<Recipe> getAllRecipesAsList(/*String email*/){
        ArrayList<Recipe> allRecipesAsList = new ArrayList<>();
        var repositoryContent = recipeRepository.findAll();
        for (Recipe i : repositoryContent){
            /*if (i.getUser() != null && i.getUser().equals(email)) {*/
                allRecipesAsList.add(i);
            //}
        }
        return allRecipesAsList;
    }

    public Long countRecipesInRepo(){
        return recipeRepository.count();
    }
}

package htw.berlin.webapp.web;
import htw.berlin.webapp.service.Recipe;
import htw.berlin.webapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JsController {


        @Autowired
        private RecipeService recipeService;

        @GetMapping("/getrecipes")
        public List<Recipe> getRecipes() {
            return recipeService.getAllRecipesAsList();
        }

        @PostMapping("/postrecipes")
        public Recipe createNewRecipe(@RequestBody Recipe newRecipe) {
            return recipeService.addRecipe(newRecipe);
        }

        @DeleteMapping("/recipes/{id}")
        public void deleteRecipeById(@PathVariable String id) {
            Long recipeId = Long.parseLong(id);
            recipeService.deleteById(recipeId);

        }


}

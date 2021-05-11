package htw.berlin.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HelloController {


        private final RecipeService recipeService = new RecipeService();

        @GetMapping("/recipe")
        public ArrayList<Recipe> recipeList(){
            return recipeService.getAllRecipesAsList();
        }

        @PostMapping("/recipe")
        public void createRecipe(@RequestBody Recipe recipe){
             recipeService.addRecipe(recipe);
        }

        @DeleteMapping("/recipe/{inputId}")
        public void removeRecipe(@PathVariable String inputId){
            Long recipeId = Long.parseLong(inputId);
            recipeService.deleteById(recipeId);
        }

        @RequestMapping("/")
        public String index() {
            return "Welcome to Your Recipes";

        }
    }

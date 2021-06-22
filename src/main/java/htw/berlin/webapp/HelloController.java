package htw.berlin.webapp;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HelloController {


        private final RecipeService recipeService = new RecipeService();

        @GetMapping("/showmyrecipes")
        public String recipeList(Model model){
            List<Recipe> recipes = recipeService.getAllRecipesAsList();
            model.addAttribute("recipes", recipes);
            return "recipelist";
        }

        @PostMapping("/createrecipe")
        public String createRecipe(@ModelAttribute Recipe recipe, Model model){
             recipeService.addRecipe(recipe);
             model.addAttribute("recipe", recipe);
             return "reciperesult";
        }

        @DeleteMapping("/recipe/{inputId}")
        public void removeRecipe(@PathVariable String inputId){
            Long recipeId = Long.parseLong(inputId);
            recipeService.deleteById(recipeId);
        }
    }

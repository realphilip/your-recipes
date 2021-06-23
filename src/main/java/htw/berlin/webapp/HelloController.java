package htw.berlin.webapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class HelloController {
        @Autowired
        private Environment environment;

        private final RecipeService recipeService = new RecipeService();

        @RequestMapping("/")
        public String index(){
            String testEnvironmentURL = Optional.of(environment.getProperty("JDBC_DATABASE_URL")).orElse("not found");
            return("Here is variable " + testEnvironmentURL);
        }


        @GetMapping("/showmyrecipes")
        public String recipeList(Model model){
            List<Recipe> recipes = recipeService.getAllRecipesAsList();
            model.addAttribute("recipes", recipes);
            return "recipelist";
        }

        @PostMapping("/createrecipe")
        public String createRecipe(@ModelAttribute Model model, Recipe recipe){
             recipeService.addRecipe(recipe);
             model.addAttribute("recipe", recipe);
             return "reciperesult";
        }

        /*@DeleteMapping("/recipe/{inputId}")
        public void removeRecipe(@PathVariable String inputId){
            Long recipeId = Long.parseLong(inputId);
            recipeService.deleteById(recipeId);*/
        
    }

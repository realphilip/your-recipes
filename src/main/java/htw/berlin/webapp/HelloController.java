package htw.berlin.webapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class HelloController {
        @Autowired
        private Environment environment;

        private final RecipeService recipeService = new RecipeService();

        private Map<String, LocalDateTime> usersLastAccess = new HashMap<>();

        @RequestMapping("/")
        public String index(){
            String testEnvironmentURL = Optional.of(environment.getProperty("JDBC_DATABASE_URL")).orElse("not found");
            return("Here is variable " + testEnvironmentURL);
        }


        @GetMapping("/showmyrecipes")
        public String recipeList(/*@AuthenticationPrincipal OidcUser creator,*/ Model model){
            List<Recipe> recipes = recipeService.getAllRecipesAsList(/*creator.getEmail()*/);
            model.addAttribute("recipes", recipes);
            return "recipelist";
        }

        @PostMapping("/createrecipe")
        public String createRecipe(/*@AuthenticationPrincipal OidcUser creator, */@ModelAttribute Model model, Recipe recipe){
             //recipe.setUser(creator.getEmail());
            recipeService.addRecipe(recipe);
             model.addAttribute("recipe", recipe);
             return "reciperesult";
        }

        /*@DeleteMapping("/recipe/{inputId}")
        public void removeRecipe(@PathVariable String inputId){
            Long recipeId = Long.parseLong(inputId);
            recipeService.deleteById(recipeId);*/
        
    }

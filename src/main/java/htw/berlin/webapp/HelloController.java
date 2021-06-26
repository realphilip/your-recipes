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
        private RecipeService recipeService;

        /*private Map<String, LocalDateTime> usersLastAccess = new HashMap<>();

    @GetMapping("/")
    public String getCurrentUser(@AuthenticationPrincipal OidcUser user, Model model) {
        String email = user.getEmail();

        model.addAttribute("email", email);
        model.addAttribute("lastAccess", usersLastAccess.get(email));

        usersLastAccess.put(email, LocalDateTime.now());

        return "welcome";
    }*/



        @GetMapping("/showmyrecipes")
        public String recipeList(/*@AuthenticationPrincipal OidcUser creator, */Model model){
            List<Recipe> recipes = recipeService.getAllRecipesAsList(/*creator.getEmail()*/);
            model.addAttribute("recipes", recipes);
            return "recipelist";
        }


    @GetMapping("/createrecipe")
    public String recipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "createrecipe";
    }

        @PostMapping("/createrecipe")
        public String createRecipe(/*@AuthenticationPrincipal OidcUser creator, */@ModelAttribute Recipe recipe, Model model){
            // recipe.setUser(/*creator.getEmail()*/);
            recipeService.addRecipe(recipe);
             model.addAttribute("recipe", recipe);
             return "reciperesult";
        }

    @GetMapping("/createvue")
    public String dynamicForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "createvue";
    }

        /*@DeleteMapping("/recipe/{inputId}")
        public void removeRecipe(@PathVariable String inputId){
            Long recipeId = Long.parseLong(inputId);
            recipeService.deleteById(recipeId);*/
        
    }

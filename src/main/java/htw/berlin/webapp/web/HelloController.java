package htw.berlin.webapp.web;


import htw.berlin.webapp.service.Recipe;
import htw.berlin.webapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import java.util.List;

//thymeleaf controller
@Controller
public class HelloController {

        @Autowired
        private RecipeService recipeService;




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
        public String createRecipe(@ModelAttribute Recipe recipe, Model model){
            recipeService.addRecipe(recipe);
             model.addAttribute("recipe", recipe);
             return "reciperesult";
        }

    @GetMapping("/createvue")
    public String dynamicForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "createvue";
    }
        
    }

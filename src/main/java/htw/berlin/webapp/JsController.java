package htw.berlin.webapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class JsController {



        @Autowired
        private Environment env;

        @RequestMapping("/env")
        public String index() {
            String testEnvValue = Optional.ofNullable(env.getProperty("TEST_VALUE")).orElse("Environment variable not found");
            return "Hey there, I know environment variables, e.g. " + testEnvValue;
        }

        @Autowired
        private RecipeService recipeService;

        @GetMapping("/getrecipes")
        public List<Recipe> getRecipes(/*@AuthenticationPrincipal OidcUser user*/) {
            return recipeService.getAllRecipesAsList(/*user.getEmail()*/);
        }

        @PostMapping("/postrecipes")
        public Recipe createNewRecipe(/*@AuthenticationPrincipal OidcUser user, */@RequestBody Recipe newRecipe) {
           //product.setOwner(user.getEmail());
            return recipeService.addRecipe(newRecipe);
        }

        @DeleteMapping("/recipes/{id}")
        public void deleteRecipeById(@PathVariable String id) {
            Long recipeId = Long.parseLong(id);
            recipeService.deleteById(recipeId);

        }


}

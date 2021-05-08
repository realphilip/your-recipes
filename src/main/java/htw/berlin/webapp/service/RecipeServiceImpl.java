package htw.berlin.webapp.service;


import htw.berlin.webapp.api.Recipe;
import htw.berlin.webapp.api.RecipeSavingRequest;
import htw.berlin.webapp.api.User;
import htw.berlin.webapp.recipes.SavedRecipesEntity;
import htw.berlin.webapp.recipes.SavedRecipesRepository;
import htw.berlin.webapp.recipes.Saving;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
//
public class RecipeServiceImpl implements RecipeService {

    private final SavedRecipesRepository repository;
    private final RestTemplate restTemplate;

    public RecipeServiceImpl(SavedRecipesRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }



    @Override
    public void saveRecipe(RecipeSavingRequest request) {
        SavedRecipesEntity savedRecipesEntity = repository.findById(request.getId()).orElseThrow(() -> new IllegalArgumentException("Can't find entity for id '" + request.getId() + "'!"));
        ratedDogEntity.setRating(Saving.SAVED);
        repository.save(ratedDogEntity);
    }

    @Override
    public void unsaveRecipe(RecipeSavingRequest request) {
        SavedRecipesEntity savedRecipesEntity = repository.findById(request.getId()).orElseThrow(() -> new IllegalArgumentException("Can't find entity for id '" + request.getId() + "'!"));
        ratedDogEntity.setRating(Saving.UNSAVED);
        repository.save(ratedDogEntity);
    }

    @Override
    public List<Recipe> fetchAllSavedRecipes() {
        return repository.findAllBySavedEquals(Saving.SAVED)
                .stream()
                .map(savedRecipes -> new User(Recipe.getId(), Recipe.getName(), Recipe.getInstructions(), Recipe.getIngredients))
                .collect(Collectors.toList());
    }
}

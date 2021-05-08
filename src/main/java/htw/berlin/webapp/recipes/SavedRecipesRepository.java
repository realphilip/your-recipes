package htw.berlin.webapp.recipes;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedRecipesRepository {
//
    List<SavedRecipesEntity> findAllBySavedEquals(Saving saving);
}

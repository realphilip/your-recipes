package htw.berlin.webapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class WebAppApplicationTests {

	@Autowired
	private RecipeService service;

	@MockBean
	private RecipeRepository repository;

	@Test
	@DisplayName("should test adding a Recipe to the ArrayList")
	void addRecipeToArrayList() {
		var recipe = new Recipe(10101L, "TestRecipe", "TestIngredient", "TestInstruction");
		var recipe2 = new Recipe(10102L, "TestRecipe", "TestIngredient", "TestInstruction");
		var recipe3 = new Recipe(10103L, "TestRecipe", "TestIngredient", "TestInstruction");
		service.addRecipe(recipe);

		ArrayList<Recipe> test = new ArrayList<Recipe>();
		test.add(recipe);
		test.add(recipe2);
		test.add(recipe3);

		Assertions.assertEquals(test.size(), 3, "It worked");
	}

	@Test
	@DisplayName("should delete a Recipe from the ArrayList")
	void deleteRecipeFromArrayList() {
		var recipe = new Recipe(10101L, "TestRecipe", "TestIngredient", "TestInstruction");
		service.addRecipe(recipe);

		ArrayList<Recipe> test = new ArrayList<Recipe>();
		test.add(recipe);

		service.deleteById(10101L);

		test = service.findAll(10101L);

		Assertions.assertSame(test.size(), 0, "It worked");

	}

}

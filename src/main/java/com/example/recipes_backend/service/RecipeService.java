package com.example.recipes_backend.service;


import com.example.recipes_backend.dto.RecipeResponse;
import com.example.recipes_backend.entity.Recipe;
import com.example.recipes_backend.repository.ReciepesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecipeService {

    private final ReciepesRepository reciepeRepository;

    private final WebClient webClient = WebClient.create();


    @Transactional
//    @Retry(name = "recipeApiRetry", fallbackMethod = "loadRecipesFallback")
//    @CircuitBreaker(name = "recipeApiCircuitBreaker", fallbackMethod = "loadRecipesFallback")
    public int loadRecipesFromApi() {
        log.info("Fetching recipes from external API : https://dummyjson.com/recipes");
        RecipeResponse response = webClient.get()
                .uri("https://dummyjson.com/recipes")
                .retrieve()
                .bodyToMono(RecipeResponse.class)
                .block();

        if (response == null || response.getRecipes() == null) {
            log.warn("No recipes fetched from API");
            return 0;
        }

        List<Recipe> saved = reciepeRepository.saveAll(response.getRecipes());
        log.info("Saved {} recipes into H2 DB", saved.size());
        return saved.size();
    }

    public List<Recipe> searchByNameOrCuisine(String keyword) {
        log.info("Fetching the list of Recipes from name or cuisine");
        return reciepeRepository.findAll().stream()
                .filter(r -> r.getName().toLowerCase().contains(keyword.toLowerCase())
                        || r.getCuisine().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    public Optional<Recipe> getRecipeById(Long id) {
        log.info("Fetching the Recipe by Id");
        return reciepeRepository.findById(id);
    }

    public int loadRecipesFallback(Throwable t) {
        log.error("Falling back due to API failure: {}", t.getMessage());
        return 0; // Could return cached count if you implement caching
    }

}

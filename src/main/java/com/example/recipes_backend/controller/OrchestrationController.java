package com.example.recipes_backend.controller;

import com.example.recipes_backend.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/recipes")
@Slf4j
public class OrchestrationController {


    private final RecipeService recipeService;

    public OrchestrationController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/load")
    public ResponseEntity<?> loadSampleRecipes() {
        log.info("Received request to load recipes from API - https://dummyjson.com/recipes into H2 DB");
        int count = recipeService.loadRecipesFromApi();
        log.info("Loaded {} recipes", count);
        return ResponseEntity.ok().body("{\"loaded\":" + count + "}");
    }
}
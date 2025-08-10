package com.example.recipes_backend.controller;


import com.example.recipes_backend.entity.Recipe;
import com.example.recipes_backend.exception.RecipeNotFoundException;
import com.example.recipes_backend.service.RecipeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
@Slf4j
public class RecipeController {

    private final RecipeService recipeService;



    @GetMapping("/search")
    public ResponseEntity<List<Recipe>> searchRecipes(@Valid @RequestParam String keyword) {
        log.info("@Class : RecipeController -> searchRecipes: key word received to search the recipes");
        List<Recipe> list = recipeService.searchByNameOrCuisine(keyword);
        if(list.isEmpty()) throw new RecipeNotFoundException("Recipe with " + keyword  + " as a name or cuisine are not available");
        return ResponseEntity.ok(recipeService.searchByNameOrCuisine(keyword));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@Valid @PathVariable Long id) {
        log.info("@Class : RecipeController -> getRecipeById: id received to get the recipe");
        return recipeService.getRecipeById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe with id "+ id+ "not found in the system"));

    }

}

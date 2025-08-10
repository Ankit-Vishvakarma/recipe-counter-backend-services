package com.example.recipes_backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipesPayloadDto {

    @NotNull(message = "Recipes list cannot be null")
    @Size(min = 1, message = "At least one recipe is required")
    @Valid // Ensures nested validation on RecipeDto
    private List<RecipeDto> recipes;
    // getters & setters

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RecipeDto {
        @NotNull(message = "Recipe ID is mandatory")
        public Long id;

        @NotBlank(message = "Recipe name is required")
        @Size(min = 3, max = 100, message = "Recipe name must be between 3 and 100 characters")
        public String name;

        @NotNull(message = "Ingredients list cannot be null")
        @Size(min = 1, message = "At least one ingredient is required")
        public List<String> ingredients;

        @NotNull(message = "Instructions list cannot be null")
        @Size(min = 1, message = "At least one instruction is required")
        public List<@NotBlank(message = "Instruction cannot be blank")String> instructions;

        @NotNull(message = "Preparation time is required")
        public Integer prepTimeMinutes;

        @NotNull(message = "Cooking time is required")
        public Integer cookTimeMinutes;

        @NotNull(message = "Servings is required")
        public Integer servings;

        @NotBlank(message = "Difficulty is required")
        public String difficulty;

        @NotBlank(message = "Cuisine is required")
        public String cuisine;

        @NotNull(message = "Calories per serving is required")
        public Integer caloriesPerServing;


        public List<@NotBlank(message = "Tag cannot be blank")String> tags;

        public Long userId;
        public String image;

        @NotNull(message = "Rating is required")
        @DecimalMin(value = "0.0", message = "Rating cannot be less than 0")
        @DecimalMax(value = "5.0", message = "Rating cannot be greater than 5")
        public Double rating;

        public Integer reviewCount;
        public List<@NotBlank(message = "Meal type cannot be blank")String> mealType;

    }

    public List<RecipeDto> getRecipes() { return recipes; }
    public void setRecipes(List<RecipeDto> recipes) { this.recipes = recipes; }
}
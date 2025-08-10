package com.example.recipes_backend.dto;

import com.example.recipes_backend.entity.Recipe;
import lombok.Data;

import java.util.List;

@Data
public class RecipeResponse {
    private List<Recipe> recipes;
}

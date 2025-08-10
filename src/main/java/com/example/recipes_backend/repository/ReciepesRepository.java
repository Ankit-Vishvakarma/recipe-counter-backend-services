package com.example.recipes_backend.repository;

import com.example.recipes_backend.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReciepesRepository extends JpaRepository<Recipe, Long> {

//    Page<Recipe> findByNameIgnoreCaseContainingOrCuisineIgnoreCaseContaining(String name, String cuisine, Pageable pageable);

}

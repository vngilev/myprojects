package ru.sbt.vngilev.recipebookaws.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class RecipeDto {

    private Long id;

    @NotNull(message = "Recipe name must not be null")
    @Size(min = 2, max = 30, message = "Recipe name must be between 2 and 20 characters")
    private String name;

    @NotNull(message = "Cooking must not be null")
    @Size(min = 2, max = 256, message = "Cooking must be between 2 and 20 characters")
    private String cooking;

    private List<IngredientDto> ingredients;

    public RecipeDto() {
//        this.ingredients = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCooking() {
        return cooking;
    }

    public void setCooking(String cooking) {
        this.cooking = cooking;
    }

    public List<IngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDto> ingredients) {
        this.ingredients = ingredients;
    }
}
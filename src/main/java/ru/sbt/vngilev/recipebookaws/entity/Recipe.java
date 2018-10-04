package ru.sbt.vngilev.recipebookaws.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "recipes")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cooking")
    private String cooking;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "recipe", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Ingredient> ingredients;

    public Recipe() {
    }

    public Recipe(Long id, String name, String cooking, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.cooking = cooking;
        this.ingredients = ingredients;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getCooking() {
        return cooking;
    }

    public void setCooking(String cooking) {
        this.cooking = cooking;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Collection<String> getIngredientNamesOfRecipe() {
        return ingredients.stream()
                .map(Ingredient::getFoodstuff)
                .map(Foodstuff::getName)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients + '\'' +
                ", cooking='" + cooking +
                '}';
    }
}
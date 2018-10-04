package ru.sbt.vngilev.recipebookaws.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ingredients")
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "foodstuff_id")
    private Foodstuff foodstuff;

    @Column(name = "quantity")
    private BigDecimal quantity;

    public Ingredient() {
    }

    public Ingredient(Long id, Recipe recipe, Foodstuff foodstuff, BigDecimal quantity) {
        this.id = id;
        this.recipe = recipe;
        this.foodstuff = foodstuff;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public void setFoodstuff(Foodstuff foodstuff) {
        this.foodstuff = foodstuff;
    }

    public Foodstuff getFoodstuff() {
        return foodstuff;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

}

package com.ubb.postuniv.domain;

public class Cake extends Entity {
    private String name;
    private String ingredients;
    private float calories;
    private float price;
    private boolean sugarFree;

    public Cake(int id, String name, String ingredients, float calories, float price, boolean sugarFree) {
        super(id);
        this.name = name;
        this.ingredients = ingredients;
        this.calories = calories;
        this.price = price;
        this.sugarFree = sugarFree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isSugarFree() {
        return sugarFree;
    }

    public void setSugarFree(boolean sugarFree) {
        this.sugarFree = sugarFree;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "id=" + this.getId() +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                ", sugarFree=" + sugarFree +
                '}';
    }
}

package com.wypychmat.pizzeria.api;

import java.lang.reflect.Constructor;
import java.util.*;

public abstract class Pizza implements BakePizzaAble {
    private Size size;
    private final Map<Ingredient, Cost> ingredients;
    private Double doughPrice;
    private String name;

    Pizza(Pizza pizza) {
        this.name = pizza.name;
        this.size = pizza.size;
        this.ingredients = pizza.ingredients;
        this.doughPrice = pizza.doughPrice;
    }

    Pizza(Double initialDoughPrice) {
        name = "Pizza";
        size = Size.small;
        this.ingredients = new HashMap<>();
        this.doughPrice = initialDoughPrice;
    }

    Map<Ingredient, Cost> getIngredients() {
        return ingredients;
    }

    Double getDoughPrice() {
        return doughPrice;
    }

    Size getSize() {
        return size;
    }

    void setSize(Size size) {
        this.size = size;
    }

    void setDoughPrice(Double doughPrice) {
        this.doughPrice = doughPrice;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public Double getCost() {
        return ingredients.values().stream().map(Cost::getCost).reduce(doughPrice, Double::sum);
    }

    public String getPizzaSize() {
        return size.name();
    }


    @Override
    public List<Ingredient> getPizzaIngredient() {
        return new ArrayList<>(ingredients.keySet());
    }

    public <T extends PizzaDecorator> Pizza decorate(Class<T> decorator) {
        try {
            Constructor<?> constructor = decorator.getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return decorator.cast(constructor.newInstance(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return size == pizza.size && Objects.equals(ingredients, pizza.ingredients) && Objects.equals(doughPrice, pizza.doughPrice) && Objects.equals(name, pizza.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, ingredients, doughPrice, name);
    }
}

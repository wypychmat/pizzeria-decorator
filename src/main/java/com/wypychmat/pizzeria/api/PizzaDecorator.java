package com.wypychmat.pizzeria.api;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class PizzaDecorator extends Pizza {

    protected PizzaDecorator(Pizza pizza) {
        super(pizza);
        decorate().accept(pizza.getIngredients());
        decorate().accept(this.getIngredients());
        String newName = buildNewName().apply(pizza.getName());
        pizza.setName(newName);
        this.setName(newName);
    }

    protected abstract Consumer<Map<Ingredient, Cost>> decorate();

    protected abstract Function<String, String> buildNewName();


}

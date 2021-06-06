package com.wypychmat.pizzeria.vip.pizza;

import com.wypychmat.pizzeria.api.Cost;
import com.wypychmat.pizzeria.api.Ingredient;
import com.wypychmat.pizzeria.api.Pizza;
import com.wypychmat.pizzeria.api.PizzaDecorator;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class Margherita extends PizzaDecorator {
    protected Margherita(Pizza pizza) {
        super(pizza);
    }

    protected Consumer<Map<Ingredient, Cost>> decorate() {
        return (ingredients) -> {
            ingredients.clear();
            ingredients.put(Ingredient.sauce, new Cost(10));
            ingredients.put(Ingredient.cheese, new Cost(12));
        };
    }

    @Override
    protected Function<String, String> buildNewName() {
        return (name) -> "Margherita";
    }
}

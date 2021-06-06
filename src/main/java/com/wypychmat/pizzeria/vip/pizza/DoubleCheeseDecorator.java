package com.wypychmat.pizzeria.vip.pizza;

import com.wypychmat.pizzeria.api.Cost;
import com.wypychmat.pizzeria.api.Ingredient;
import com.wypychmat.pizzeria.api.Pizza;
import com.wypychmat.pizzeria.api.PizzaDecorator;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class DoubleCheeseDecorator extends PizzaDecorator {

    public DoubleCheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    protected Consumer<Map<Ingredient, Cost>> decorate() {
        return (ingredients -> {
            ingredients.remove(Ingredient.cheese);
            ingredients.put(Ingredient.doubleCheese, new Cost(24));
        });
    }

    @Override
    protected Function<String, String> buildNewName() {
        return (name) -> "Double cheese " + name;
    }
}

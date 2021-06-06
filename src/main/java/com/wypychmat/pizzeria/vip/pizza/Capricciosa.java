package com.wypychmat.pizzeria.vip.pizza;

import com.wypychmat.pizzeria.api.Cost;
import com.wypychmat.pizzeria.api.Ingredient;
import com.wypychmat.pizzeria.api.Pizza;
import com.wypychmat.pizzeria.api.PizzaDecorator;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.wypychmat.pizzeria.api.Ingredient.*;

public class Capricciosa extends PizzaDecorator {
    protected Capricciosa(Pizza pizza) {
        super(pizza);
    }

    @Override
    protected Consumer<Map<Ingredient, Cost>> decorate() {
        return (ingredient -> {
            ingredient.clear();
            ingredient.put(sauce, new Cost(6));
            ingredient.put(ham, new Cost(12));
            ingredient.put(onion, new Cost(3));
            ingredient.put(mushrooms, new Cost(4));
            ingredient.put(cheese, new Cost(12));
        });
    }

    @Override
    protected Function<String, String> buildNewName() {
        return (name)-> "Capricciosa";
    }
}

package com.wypychmat.pizzeria.cheep.pizza;

import com.wypychmat.pizzeria.PizzeriaTestBase;
import com.wypychmat.pizzeria.api.Ingredient;
import com.wypychmat.pizzeria.api.Pizza;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DoubleCheeseDecoratorTest extends PizzeriaTestBase {

    @Test
    void shouldBeMargheritaDecoratedWithDoubleCheese() {
        //given
        Pizza margherita = pizzaChef.prepareDough().decorate(Margherita.class);
        //when
        margherita.decorate(DoubleCheeseDecorator.class);
        //then
        assertThat(margherita.getPizzaIngredient())
                .has(new Condition<>((el) -> el.contains(Ingredient.doubleCheese), Ingredient.doubleCheese.name()));
        assertThat(margherita.getPizzaIngredient())
                .doesNotHave(new Condition<>((el) -> el.contains(Ingredient.cheese), Ingredient.cheese.name()));

    }
}
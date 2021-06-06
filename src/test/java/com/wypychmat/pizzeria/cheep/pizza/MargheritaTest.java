package com.wypychmat.pizzeria.cheep.pizza;

import com.wypychmat.pizzeria.PizzeriaTestBase;
import com.wypychmat.pizzeria.api.Ingredient;
import com.wypychmat.pizzeria.api.Pizza;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MargheritaTest extends PizzeriaTestBase {

    @Test
    void shouldMargheritaDecoratorBeAppliedWhenApplied() {
        //given
        Pizza pizza = pizzaChef.prepareDough();
        //when
        new Margherita(pizza);
        //then
        assertThat(pizza.getName()).isEqualTo("Margherita");
        assertThat(pizza.getPizzaIngredient().stream().sorted().collect(Collectors.toList()))
                .isEqualTo(Stream.of(Ingredient.cheese, Ingredient.sauce).sorted().collect(Collectors.toList()));
    }

    @Test
    void shouldNotBeTwiceMargheritaDecorated() {
        //given
        Pizza pizza = pizzaChef.prepareDough();
        //when
        Margherita margherita = new Margherita(pizza);
        Margherita doubleDecorated = new Margherita(margherita);
        //then
        assertThat(pizza.getName()).isEqualTo("Margherita");
        assertThat(pizza.getPizzaIngredient().size()).isEqualTo(2);
    }

    @Test
    void shouldDecoratedResultBeTheSame() {
        //given
        Pizza pizza = pizzaChef.prepareDough();
        Pizza otherPizza = pizzaChef.prepareDough();
        //when
        Pizza decorate = pizza.decorate(Margherita.class);
        Margherita margherita = new Margherita(otherPizza);
        //then
        assertThat(pizza).isEqualTo(otherPizza);
        assertThat(decorate).isEqualTo(margherita);
    }
}
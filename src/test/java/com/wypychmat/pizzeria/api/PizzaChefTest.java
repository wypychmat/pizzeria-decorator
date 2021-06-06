package com.wypychmat.pizzeria.api;

import com.wypychmat.pizzeria.PizzeriaTestBase;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.data.Offset.offset;

class PizzaChefTest extends PizzeriaTestBase {

    @Test
    void shouldPizzaBeCreated() {
        //given

        //when
        Pizza pizza = pizzaChef.prepareDough();
        // then
        assertThat(pizza.getName()).isNotBlank();
        assertThat(pizza.getPizzaSize()).isNotBlank();
    }

    @Test
    void shouldCostOfPizzaAfterCreatingBeEqualToDoughCost() {
        //given

        //when
        Pizza pizza = pizzaChef.prepareDough();
        // then
        assertThat(pizza.getCost()).isEqualTo(DOUGH_COST, offset(0.001));
    }

    @Test
    void shouldCostOfPizzaIncreaseAfterChangeSize() {
        // given
        Pizza pizza = pizzaChef.prepareDough();
        // when
        pizzaChef.resize(pizza, Size.large);
        //then
        assertThat(pizza.getCost())
                .isEqualTo(DOUGH_COST * Size.large.getPriceMultiplier() * DOUGH_PRICE_SCALE, offset(0.001d));
        assertThat(pizza.getCost()).isGreaterThan(DOUGH_COST);
    }


    @Test
    void shouldChangePizzaSize() {
        // given
        Pizza pizza = pizzaChef.prepareDough();
        // when
        pizzaChef.resize(pizza, Size.large);
        //then
        assertThat(pizza.getSize()).isEqualTo(Size.large);
    }


    @Test
    void shouldChangeIngredientsCostAfterResize() {
        // given
        Pizza pizza = pizzaChef.prepareDough();
        Map<Ingredient, Cost> ingredients = pizza.getIngredients();
        int ingredientCost = 5;
        ingredients.put(Ingredient.sauce, new Cost(ingredientCost));
        ingredients.put(Ingredient.ham, new Cost(ingredientCost));
        // when
        pizzaChef.resize(pizza, Size.large);
        //then
        assertThat(pizza.getCost() - pizza.getDoughPrice())
                .isEqualTo(2 * ingredientCost * MULTIPLIER_LARGE, offset(0.001));
    }

}
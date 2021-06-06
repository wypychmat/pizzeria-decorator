package com.wypychmat.pizzeria;

import com.wypychmat.pizzeria.api.PizzaChef;
import com.wypychmat.pizzeria.api.PriceProviderImpl;
import com.wypychmat.pizzeria.api.PricingConfig;

public class PizzeriaTestBase {

    public static final double DOUGH_COST = 1d;
    public static final double DOUGH_PRICE_SCALE = 1d;
    public static final double MULTIPLIER_SMALL = 1d;
    public static final double MULTIPLIER_MEDIUM = 2d;
    public static final double MULTIPLIER_LARGE = 3d;

    public final PizzaChef pizzaChef;

    public PizzeriaTestBase() {
        pizzaChef = new PizzaChef(new PriceProviderImpl(getPricingConfig()));
    }


    private static PricingConfig getPricingConfig() {
        PricingConfig pricingConfig = new PricingConfig();
        pricingConfig.setDoughCost(DOUGH_COST);
        pricingConfig.setDoughPriceScale(DOUGH_PRICE_SCALE);
        pricingConfig.setMultiplierSmall(MULTIPLIER_SMALL);
        pricingConfig.setMultiplierMedium(MULTIPLIER_MEDIUM);
        pricingConfig.setMultiplierLarge(MULTIPLIER_LARGE);
        return pricingConfig;
    }
}

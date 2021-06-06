package com.wypychmat.pizzeria.api;

import org.springframework.stereotype.Component;

@Component
public class PizzaChef {
    private final PriceProvider priceProvider;

    public PizzaChef(PriceProvider priceProvider) {
        this.priceProvider = priceProvider;
        Size.small.setPriceMultiplier(priceProvider.getSmallMultiplier());
        Size.medium.setPriceMultiplier(priceProvider.getMediumMultiplier());
        Size.large.setPriceMultiplier(priceProvider.getLargeMultiplier());
    }

    public Pizza prepareDough() {
        return new PizzaDough(
                priceProvider.getInitialDoughCost());
    }

    public void resize(Pizza pizza, Size size) {
        Size actualSize = pizza.getSize();
        if (!actualSize.equals(size)) {
            double actualSizePriceMultiplier = actualSize.getPriceMultiplier();
            resizePizzaIngredients(pizza, size, actualSizePriceMultiplier);
            resizeDough(pizza, actualSizePriceMultiplier,size);
            pizza.setSize(size);
        }
    }

    private void resizeDough(Pizza pizza, double actualSizePriceMultiplier, Size size) {
        pizza.setDoughPrice((pizza.getDoughPrice() /
                (actualSizePriceMultiplier * priceProvider.getDoughPriceScale()))
                * (priceProvider.getDoughPriceScale() * size.getPriceMultiplier()));
    }

    private void resizePizzaIngredients(Pizza pizza, Size size, double actualSizePriceMultiplier) {
        pizza.getIngredients().values().forEach(cost ->
                cost.setCost((cost.getCost() / actualSizePriceMultiplier) * size.getPriceMultiplier()));
    }


}

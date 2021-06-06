package com.wypychmat.pizzeria.api;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Primary
public class PriceProviderImpl implements PriceProvider {


    private final PricingConfig pricingConfig;

    public PriceProviderImpl(PricingConfig pricingConfig) {
        this.pricingConfig = pricingConfig;
    }


    @Override
    public double getInitialDoughCost() {
        return pricingConfig.getDoughCost();
    }

    @Override
    public double getSmallMultiplier() {
        return pricingConfig.getMultiplierSmall();
    }

    @Override
    public double getMediumMultiplier() {
        return pricingConfig.getMultiplierMedium();
    }

    @Override
    public double getLargeMultiplier() {
        return pricingConfig.getMultiplierLarge();
    }

    @Override
    public double getDoughPriceScale() {
        return pricingConfig.getDoughPriceScale();
    }
}

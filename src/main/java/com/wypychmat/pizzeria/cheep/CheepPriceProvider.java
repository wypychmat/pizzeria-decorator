package com.wypychmat.pizzeria.cheep;

import com.wypychmat.pizzeria.api.PriceProvider;
import com.wypychmat.pizzeria.api.PricingConfig;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "cheep")
public class CheepPriceProvider implements PriceProvider {

    private final PricingConfig pricingConfig;

    protected CheepPriceProvider(PricingConfig pricingConfig) {
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

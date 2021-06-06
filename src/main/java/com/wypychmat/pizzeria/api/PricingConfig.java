package com.wypychmat.pizzeria.api;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "pizza")
public class PricingConfig {

    private Double doughCost;
    private Double doughPriceScale;
    private Double multiplierSmall;
    private Double multiplierMedium;
    private Double multiplierLarge;


    public Double getDoughCost() {
        return doughCost;
    }

    public void setDoughCost(Double doughCost) {
        this.doughCost = doughCost;
    }

    public Double getDoughPriceScale() {
        return doughPriceScale;
    }

    public void setDoughPriceScale(Double doughPriceScale) {
        this.doughPriceScale = doughPriceScale;
    }

    public Double getMultiplierSmall() {
        return multiplierSmall;
    }

    public void setMultiplierSmall(Double multiplierSmall) {
        this.multiplierSmall = multiplierSmall;
    }

    public Double getMultiplierMedium() {
        return multiplierMedium;
    }

    public void setMultiplierMedium(Double multiplierMedium) {
        this.multiplierMedium = multiplierMedium;
    }

    public Double getMultiplierLarge() {
        return multiplierLarge;
    }

    public void setMultiplierLarge(Double multiplierLarge) {
        this.multiplierLarge = multiplierLarge;
    }
}

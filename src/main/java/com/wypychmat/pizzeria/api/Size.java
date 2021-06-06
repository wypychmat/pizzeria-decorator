package com.wypychmat.pizzeria.api;

public enum Size {
    small, medium, large;

    private double priceMultiplier;

    public void setPriceMultiplier(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }
}

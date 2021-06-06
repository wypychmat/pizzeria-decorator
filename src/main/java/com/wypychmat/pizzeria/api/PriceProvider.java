package com.wypychmat.pizzeria.api;

public interface PriceProvider {


    double getInitialDoughCost();


    double getSmallMultiplier();


    double getMediumMultiplier();


    double getLargeMultiplier();

    double getDoughPriceScale();


}

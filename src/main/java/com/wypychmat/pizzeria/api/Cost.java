package com.wypychmat.pizzeria.api;

import java.util.Objects;

public class Cost {
    private double cost;

    public Cost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cost cost1 = (Cost) o;
        return Double.compare(cost1.cost, cost) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost);
    }
}

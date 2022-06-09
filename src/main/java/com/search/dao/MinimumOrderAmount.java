package com.search.dao;

public class MinimumOrderAmount {

    public String currency;
    public double value;

    public MinimumOrderAmount() {
    }

    public MinimumOrderAmount(String currency, double value) {
        this.currency = currency;
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

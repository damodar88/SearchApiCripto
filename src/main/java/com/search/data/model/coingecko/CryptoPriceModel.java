package com.search.data.model.coingecko;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class CryptoPriceModel {

    private final Map<String, Double> prices = new HashMap<>();

    @JsonProperty("last_updated_at")
    private long lastUpdatedAt;

    @JsonAnySetter
    public void addPrice(String currency, Double value) {
        prices.put(currency, value);
    }

    public Map<String, Double> getPrices() {
        return prices;
    }

    public long getLastUpdatedAt() {
        return lastUpdatedAt;
    }

}





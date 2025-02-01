package com.search.data.model.coingecko;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class CryptoModel {
    private final Map<String, CurrencyData> currencies;
    private final long lastUpdatedAt;

    // Constructor privado para inmutabilidad
    private CryptoModel(Builder builder) {
        this.currencies = builder.currencies;
        this.lastUpdatedAt = builder.lastUpdatedAt;
    }

    // Método para deserialización con Jackson
    @JsonAnySetter
    public void addCurrency(String currencyCode, CurrencyData data) {
        this.currencies.put(currencyCode.toLowerCase(), data);
    }

    // Getters (inmutables)
    public Map<String, CurrencyData> getCurrencies() {
        return new HashMap<>(currencies); // Copia defensiva
    }

    public long getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    // Clase Builder
    public static class Builder {
        private Map<String, CurrencyData> currencies = new HashMap<>();
        private long lastUpdatedAt;

        public Builder withCurrency(String currencyCode, CurrencyData data) {
            this.currencies.put(currencyCode.toLowerCase(), data);
            return this;
        }

        public Builder withLastUpdatedAt(long lastUpdatedAt) {
            this.lastUpdatedAt = lastUpdatedAt;
            return this;
        }

        public CryptoModel build() {
            return new CryptoModel(this);
        }
    }

    // Clase CurrencyData con Builder
    public static class CurrencyData {
        private final double price;
        private final double marketCap;
        private final double volume24h;
        private final double change24h;

        @JsonCreator
        public CurrencyData(
                @JsonProperty("price") double price,
                @JsonProperty("market_cap") double marketCap,
                @JsonProperty("volume_24h") double volume24h,
                @JsonProperty("change_24h") double change24h
        ) {
            this.price = price;
            this.marketCap = marketCap;
            this.volume24h = volume24h;
            this.change24h = change24h;
        }

        // Getters
        public double getPrice() {
            return price;
        }

        public double getMarketCap() {
            return marketCap;
        }

        public double getVolume24h() {
            return volume24h;
        }

        public double getChange24h() {
            return change24h;
        }

        // Builder para CurrencyData (opcional)
        public static class CurrencyDataBuilder {
            private double price;
            private double marketCap;
            private double volume24h;
            private double change24h;

            public CurrencyDataBuilder withPrice(double price) {
                this.price = price;
                return this;
            }

            public CurrencyDataBuilder withMarketCap(double marketCap) {
                this.marketCap = marketCap;
                return this;
            }

            public CurrencyDataBuilder withVolume24h(double volume24h) {
                this.volume24h = volume24h;
                return this;
            }

            public CurrencyDataBuilder withChange24h(double change24h) {
                this.change24h = change24h;
                return this;
            }

            public CurrencyData build() {
                return new CurrencyData(price, marketCap, volume24h, change24h);
            }
        }
    }
}


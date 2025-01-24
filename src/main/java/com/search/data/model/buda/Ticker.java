package com.search.data.model.buda;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Ticker {

    @JsonProperty("last_price")
    private List<String> lastPrice;

    @JsonProperty("market_id")
    private String marketId;

    @JsonProperty("max_bid")
    private List<String> maxBid;

    @JsonProperty("min_ask")
    private List<String> minAsk;

    @JsonProperty("price_variation_24h")
    private String priceVariation24h;

    @JsonProperty("price_variation_7d")
    private String priceVariation7d;

    private List<String> volume;


    private Ticker(Builder builder){
        this.lastPrice = builder.lastPrice;
        this.marketId = builder.marketId;
        this.maxBid = builder.maxBid;
        this.minAsk = builder.minAsk;
        this.priceVariation24h = builder.priceVariation24h;
        this.priceVariation7d = builder.priceVariation7d;
        this.volume = builder.volume;
    }

    public List<String> getLastPrice() {
        return lastPrice;
    }

    public String getMarketId() {
        return marketId;
    }

    public List<String> getMaxBid() {
        return maxBid;
    }

    public List<String> getMinAsk() {
        return minAsk;
    }

    public String getPriceVariation24h() {
        return priceVariation24h;
    }

    public String getPriceVariation7d() {
        return priceVariation7d;
    }

    public List<String> getVolume() {
        return volume;
    }

    public static class Builder{
        private List<String> lastPrice;
        private String marketId;
        private List<String> maxBid;
        private List<String> minAsk;
        private String priceVariation24h;
        private String priceVariation7d;
        private List<String> volume;

        public Builder withLastPrice(List<String> lastPrice) {
            this.lastPrice = lastPrice;
            return this; // Encadenamiento
        }

        public Builder withMarketId(String marketId) {
            this.marketId = marketId;
            return this;
        }

        public Builder withMaxBid(List<String> maxBid) {
            this.maxBid = maxBid;
            return this;
        }

        public Builder withMinAsk(List<String> minAsk) {
            this.minAsk = minAsk;
            return this;
        }

        public Builder withPriceVariation24h(String priceVariation24h) {
            this.priceVariation24h = priceVariation24h;
            return this;
        }

        public Builder withPriceVariation7d(String priceVariation7d) {
            this.priceVariation7d = priceVariation7d;
            return this;
        }

        public Builder withVolume(List<String> volume) {
            this.volume = volume;
            return this;
        }

        public Ticker build(){
            return new Ticker(this);
        }
    }
}

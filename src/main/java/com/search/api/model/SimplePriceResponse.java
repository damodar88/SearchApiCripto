package com.search.api.model;


public class SimplePriceResponse {

    private double usd;
    private double usdMarketCap;
    private double usd24hVol;
    private double usd24hChange;
    private long lastUpdatedAt;

    private SimplePriceResponse(Builder builder){
        this.usd = builder.usd;
        this.usdMarketCap = builder.usdMarketCap;
        this.usd24hVol = builder.usd24hVol;
        this.usd24hChange = builder.usd24hChange;
        this.lastUpdatedAt = builder.lastUpdatedAt;
    }

    public static class Builder{
        private double usd;
        private double usdMarketCap;
        private double usd24hVol;
        private double usd24hChange;
        private long lastUpdatedAt;

        public Builder usd(double usd){
            this.usd = usd;
            return this;
        }

        public Builder usdMarketCap(double usdMarketCap){
            this.usdMarketCap = usdMarketCap;
            return this;
        }

        public Builder usd24hVol(double usd24hVol){
            this.usd24hVol = usd24hVol;
            return this;
        }

        public Builder usd24hChange(double usd24hChange){
            this.usd24hChange = usd24hChange;
            return this;
        }

        public Builder lastUpdatedAt(long lastUpdatedAt){
            this.lastUpdatedAt = lastUpdatedAt;
            return this;
        }

        public SimplePriceResponse build(){
            return new SimplePriceResponse(this);
        }
    }

    public double getUsd() {
        return usd;
    }

    public double getUsdMarketCap() {
        return usdMarketCap;
    }

    public double getUsd24hVol() {
        return usd24hVol;
    }

    public double getUsd24hChange() {
        return usd24hChange;
    }

    public long getLastUpdatedAt() {
        return lastUpdatedAt;
    }
}

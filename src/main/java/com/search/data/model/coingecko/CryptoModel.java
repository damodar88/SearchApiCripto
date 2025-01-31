package com.search.data.model.coingecko;

public class CryptoModel {

    private double usd;
    private double usdMarketCap;
    private double usd24hVol;
    private double usd24hChange;
    private long lastUpdatedAt;

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getUsdMarketCap() {
        return usdMarketCap;
    }

    public void setUsdMarketCap(double usdMarketCap) {
        this.usdMarketCap = usdMarketCap;
    }

    public double getUsd24hVol() {
        return usd24hVol;
    }

    public void setUsd24hVol(double usd24hVol) {
        this.usd24hVol = usd24hVol;
    }

    public double getUsd24hChange() {
        return usd24hChange;
    }

    public void setUsd24hChange(double usd24hChange) {
        this.usd24hChange = usd24hChange;
    }

    public long getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(long lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}

package com.search.domain.modeldto;

public class BitcoinResponseDto {
    private double usd;
    private double usdMarketCap;
    private double usd24hVol;
    private double usd24hChange;
    private long lastUpdatedAt;

    private BitcoinResponseDto(Builder builder) {
        this.usd = builder.usd;
        this.usdMarketCap = builder.usdMarketCap;
        this.usd24hVol = builder.usd24hVol;
        this.usd24hChange = builder.usd24hChange;
        this.lastUpdatedAt = builder.lastUpdatedAt;
    }

    public static class Builder {
        private double usd;
        private double usdMarketCap;
        private double usd24hVol;
        private double usd24hChange;
        private long lastUpdatedAt;

        public Builder usd(double usd) {
            this.usd = usd;
            return this;
        }

        public Builder usdMarketCap(double usdMarketCap) {
            this.usdMarketCap = usdMarketCap;
            return this;
        }

        public Builder usd24hVol(double usd24hVol) {
            this.usd24hVol = usd24hVol;
            return this;
        }

        public Builder usd24hChange(double usd24hChange) {
            this.usd24hChange = usd24hChange;
            return this;
        }

        public Builder lastUpdatedAt(long lastUpdatedAt) {
            this.lastUpdatedAt = lastUpdatedAt;
            return this;
        }

        public BitcoinResponseDto build() {
            return new BitcoinResponseDto(this);
        }
    }

    // Getters
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

    @Override
    public String toString() {
        return "BitcoinResponseDto{" +
                "usd=" + usd +
                ", usdMarketCap=" + usdMarketCap +
                ", usd24hVol=" + usd24hVol +
                ", usd24hChange=" + usd24hChange +
                ", lastUpdatedAt=" + lastUpdatedAt +
                '}';
    }
}
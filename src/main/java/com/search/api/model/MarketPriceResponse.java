package com.search.api.model;

import java.util.List;

public class MarketPriceResponse {

    private final String cryptoId;
    private final String currency;
    private final List<PlatformPrice> prices;

    private MarketPriceResponse(Builder build){
        this.cryptoId = build.cryptoId;
        this.currency = build.currency;
        this.prices = build.prices;
    }

    public String getCryptoId() {
        return cryptoId;
    }

    public String getCurrency() {
        return currency;
    }

    public List<PlatformPrice> getPrices() {
        return prices;
    }

    public static final class Builder{

        private String cryptoId;
        private String currency;
        private List<PlatformPrice> prices;

        public Builder cryptoId(String cryptoId){
            this.cryptoId = cryptoId;
            return this;
        }

        public Builder currency(String currency){
            this.currency = currency;
            return this;
        }

        public Builder prices(List<PlatformPrice> prices){
            this.prices = prices;
            return this;
        }

        public MarketPriceResponse build(){
            return new MarketPriceResponse(this);
        }
    }
}

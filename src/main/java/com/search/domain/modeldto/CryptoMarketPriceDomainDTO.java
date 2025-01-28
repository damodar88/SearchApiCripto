package com.search.domain.modeldto;

import java.util.List;

public class CryptoMarketPriceDomainDTO {

    private String cryptoId;
    private String currency;
    private List<MarketPriceDomainDTO> marketPrices;

    private CryptoMarketPriceDomainDTO(Builder builder){
        this.cryptoId = builder.cryptoId;
        this.currency = builder.currency;
        this.marketPrices = builder.marketPrices;
    }

    public String getCryptoId() {
        return cryptoId;
    }

    public String getCurrency() {
        return currency;
    }

    public List<MarketPriceDomainDTO> getMarketPrices() {
        return marketPrices;
    }

    public static class Builder{
        private String cryptoId;
        private String currency;
        private List<MarketPriceDomainDTO> marketPrices;

        public Builder withCryptoId(String cryptoId) {
            this.cryptoId = cryptoId;
            return this;
        }

        public Builder withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder withMarketPrices(List<MarketPriceDomainDTO> marketPrices) {
            this.marketPrices = marketPrices;
            return this;
        }

        public CryptoMarketPriceDomainDTO build(){
            return new CryptoMarketPriceDomainDTO(this);
        }
    }


}
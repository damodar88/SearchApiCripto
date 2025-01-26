package com.search.data.model.buda;

public class CryptoPriceResponse {

    private Ticker ticker;

    private CryptoPriceResponse(Builder builder){
        this.ticker = builder.ticker;
    }

    public Ticker getTicker(){
        return ticker;
    }

    public static class Builder{

        private Ticker ticker;

        public Builder ticker(Ticker ticker){
            this.ticker = ticker;
            return this;
        }

        public CryptoPriceResponse build(){
            return new CryptoPriceResponse(this);
        }
    }
}

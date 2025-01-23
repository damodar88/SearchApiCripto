package com.search.data.model.buda;

public class MarketTickerResponse {

    private Ticker ticker;

    private MarketTickerResponse(Builder builder){
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

        public MarketTickerResponse build(){
            return new MarketTickerResponse(this);
        }
    }
}

package com.search.api.model;

public class SimplePriceResponse {

    private Bitcoin bitcoin;

    private SimplePriceResponse(Builder build){
        this.bitcoin = build.bitcoin;
    }

    public Bitcoin getBitcoin(){
        return bitcoin;
    }

    public static class Builder{
        private Bitcoin bitcoin;

        public Builder bitcoin(Bitcoin bitcoin){
            this.bitcoin = bitcoin;
            return this;
        }

        public SimplePriceResponse build(){
            return new SimplePriceResponse(this);
        }
    }

}

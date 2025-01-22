package com.search.domain.modeldto;

import com.search.api.model.SimplePriceResponse;

public class BitcoinResponseDto {

    private BitcoinDto bitcoin;

    private BitcoinResponseDto(Builder builder){
        this.bitcoin = builder.bitcoin;
    }

    public BitcoinDto getBitcoin(){
        return bitcoin;
    }

    public static class Builder{
        private BitcoinDto bitcoin;

        public Builder bitcoin(BitcoinDto bitcoin){
            this.bitcoin = bitcoin;
            return this;
        }

        public BitcoinResponseDto build(){
            return new BitcoinResponseDto(this);
        }
    }
}
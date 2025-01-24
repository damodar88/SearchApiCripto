package com.search.data.model.coingecko;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoingeckoSimplePriceResponse {

    @JsonProperty("bitcoin")
    private BitcoinModel bitcoin;

    public BitcoinModel getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(BitcoinModel bitcoin) {
        this.bitcoin = bitcoin;
    }
}

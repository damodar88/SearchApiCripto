package com.search.gateway.simplepricegatewayimpl.model.response;

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

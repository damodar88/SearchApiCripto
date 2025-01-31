package com.search.data.model.coingecko;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class CoinGeckoCryptoResponse {
    private final Map<String, CryptoModel> cryptos = new HashMap<>();

    @JsonAnySetter
    public void addCrypto(String name, CryptoModel crypto) {
        cryptos.put(name, crypto);
    }

    public Map<String, CryptoModel> getCryptos() {
        return cryptos;
    }
}

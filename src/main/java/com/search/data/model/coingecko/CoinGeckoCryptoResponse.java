package com.search.data.model.coingecko;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class CoinGeckoCryptoResponse {
    private final Map<String, CryptoPriceModel> cryptos = new HashMap<>();

    @JsonAnySetter
    public void addCrypto(String cryptoName, CryptoPriceModel data) {
        cryptos.put(cryptoName, data);
    }

    public Map<String, CryptoPriceModel> getCryptos() {
        return cryptos;
    }
}

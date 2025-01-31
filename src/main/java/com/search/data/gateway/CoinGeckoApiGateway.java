package com.search.data.gateway;

import com.search.data.model.coingecko.CoinGeckoCryptoResponse;

public interface CoinGeckoApiGateway {

    CoinGeckoCryptoResponse getSimplePrice(String id, String currency);
}

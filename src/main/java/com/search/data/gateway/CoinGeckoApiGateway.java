package com.search.data.gateway;

import com.search.data.model.coingecko.CoingeckoSimplePriceResponse;

public interface CoinGeckoApiGateway {

    CoingeckoSimplePriceResponse getSimplePrice(String id, String currency);
}

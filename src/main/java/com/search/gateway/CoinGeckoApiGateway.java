package com.search.gateway;

import com.search.gateway.simplepricegatewayimpl.model.response.CoingeckoSimplePriceResponse;

public interface CoinGeckoApiGateway {

    CoingeckoSimplePriceResponse getSimplePrice(String id, String currency);
}

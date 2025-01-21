package com.search.gateway;

import com.search.gateway.simplepricegatewayimpl.model.response.CoingeckoSimplePriceResponse;

public interface CoingeckoSimplePriceGateway {

    CoingeckoSimplePriceResponse getSimplePrice(String id, String currency);
}

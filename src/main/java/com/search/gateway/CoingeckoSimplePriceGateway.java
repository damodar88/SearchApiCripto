package com.search.gateway;

import com.search.gateway.simplepricegatewayimpl.model.response.CoingeckoSimplePriceResponse;

public interface CoingeckoSimplePriceGateway {

    public CoingeckoSimplePriceResponse getSimplePrice(String id, String currency);
}

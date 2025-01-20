package com.search.gateway;

import com.search.gateway.coingeckosupportedurrenciesimpl.model.CoingeckoSimplePriceResponse;

public interface CoingeckoSimplePriceGateway {

    public CoingeckoSimplePriceResponse getSimplePrice(String id, String currency);
}

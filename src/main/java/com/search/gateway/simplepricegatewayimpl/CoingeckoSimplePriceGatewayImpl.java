package com.search.gateway.simplepricegatewayimpl;

import com.search.gateway.CoingeckoSimplePriceGateway;
import com.search.gateway.coingeckosupportedurrenciesimpl.model.CoingeckoSimplePriceResponse;
import org.springframework.stereotype.Repository;

@Repository
public class CoingeckoSimplePriceGatewayImpl implements CoingeckoSimplePriceGateway {

    @Override
    public CoingeckoSimplePriceResponse getSimplePrice(String id, String currency) {
        return null;
    }
}

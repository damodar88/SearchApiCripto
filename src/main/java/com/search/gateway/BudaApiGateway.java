package com.search.gateway;

import com.search.gateway.budaapigatewayimpl.model.response.MarketTickerResponse;

public interface BudaApiGateway {

     MarketTickerResponse getMarketTicker(String marketId);
}

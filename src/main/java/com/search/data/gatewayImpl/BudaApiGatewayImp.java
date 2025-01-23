package com.search.data.gatewayImpl;

import com.search.data.client.BudaApiClient;
import com.search.data.gateway.BudaApiGateway;
import com.search.data.model.buda.MarketTickerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudaApiGatewayImp implements BudaApiGateway {

    private final BudaApiClient budaApiClient;

    @Autowired
    public BudaApiGatewayImp(BudaApiClient budaApiClient) {
        this.budaApiClient = budaApiClient;
    }

    @Override
    public MarketTickerResponse getMarketTicker(String marketId) {
        return budaApiClient.getMarketTicker(marketId);
    }
}

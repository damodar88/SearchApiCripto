package com.search.data.gatewayimpl;

import com.search.data.client.BudaApiClient;
import com.search.data.gateway.BudaApiGateway;
import com.search.data.model.buda.CryptoPriceResponse;
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
    public CryptoPriceResponse getMarketTicker(String marketId) {
        return budaApiClient.getMarketTicker(marketId);
    }
}

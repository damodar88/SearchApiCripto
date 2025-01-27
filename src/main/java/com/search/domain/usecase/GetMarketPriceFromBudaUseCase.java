package com.search.domain.usecase;

import com.search.data.gateway.BudaApiGateway;
import com.search.domain.mapper.BudaMarketPriceMapper;
import com.search.domain.modeldto.CryptoMarketPriceDomainDTO;

public class GetMarketPriceFromBudaUseCase {

    public final BudaApiGateway budaApiGateway;

    public final BudaMarketPriceMapper mapper;

    public GetMarketPriceFromBudaUseCase(BudaApiGateway budaApiGateway, BudaMarketPriceMapper mapper) {
        this.budaApiGateway = budaApiGateway;
        this.mapper = mapper;
    }

    public CryptoMarketPriceDomainDTO getBitcoinPrice(String marketId){
        return mapper.mapBudaBitcoinPriceToDto(budaApiGateway.getMarketTicker(marketId));
    }
}

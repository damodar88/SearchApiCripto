package com.search.domain.usecase;

import com.search.data.gateway.BudaApiGateway;
import com.search.domain.mapper.BudaBitcoinPriceMapper;
import com.search.domain.modeldto.BitcoinResponseDto;

public class GetCryptoPriceFromBudaUseCase {

    public final BudaApiGateway budaApiGateway;

    public final BudaBitcoinPriceMapper mapper;

    public GetCryptoPriceFromBudaUseCase(BudaApiGateway budaApiGateway, BudaBitcoinPriceMapper mapper) {
        this.budaApiGateway = budaApiGateway;
        this.mapper = mapper;
    }

    public BitcoinResponseDto getBitcoinPrice(String marketId){
        return mapper.mapBudaBitcoinPriceToDto(budaApiGateway.getMarketTicker(marketId));
    }
}

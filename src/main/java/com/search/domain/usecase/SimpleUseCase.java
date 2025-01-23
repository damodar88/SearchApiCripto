package com.search.domain.usecase;

import com.search.domain.mapper.SimplePriceMapper;
import com.search.domain.modeldto.BitcoinResponseDto;
import com.search.gateway.CoinGeckoApiGateway;
import com.search.gateway.simplepricegatewayimpl.model.response.CoingeckoSimplePriceResponse;
import org.springframework.stereotype.Service;

@Service
public class SimpleUseCase {

    private final CoinGeckoApiGateway gateway;

    private final SimplePriceMapper mapper;

    public SimpleUseCase(CoinGeckoApiGateway gateway, SimplePriceMapper mapper) {
        this.gateway = gateway;
        this.mapper = mapper;
    }

    public BitcoinResponseDto getSimplePrice(String id, String vsCurrencies) {
        CoingeckoSimplePriceResponse response = gateway.getSimplePrice(id, vsCurrencies);
        return  mapper.coingeckoSimplePriceToSimpleUseCaseDto(response);
    }



}

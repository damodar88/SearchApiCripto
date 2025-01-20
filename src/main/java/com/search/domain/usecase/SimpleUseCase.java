package com.search.domain.usecase;

import com.search.domain.mapper.SimplePriceMapper;
import com.search.domain.modelDto.BitcoinResponseDto;
import com.search.gateway.CoingeckoSimplePriceGateway;
import com.search.gateway.coingeckoSupportedurrenciesImpl.model.CoingeckoSimplePriceResponse;

public class SimpleUseCase {

    private final CoingeckoSimplePriceGateway gateway;

    private final SimplePriceMapper mapper;

    public SimpleUseCase(CoingeckoSimplePriceGateway gateway, SimplePriceMapper mapper) {
        this.gateway = gateway;
        this.mapper = mapper;
    }

    public BitcoinResponseDto getSimplePrice(String id, String vsCurrencies) {
        BitcoinResponseDto bitcoinResponseDto = new BitcoinResponseDto();
        CoingeckoSimplePriceResponse response = gateway.getSimplePrice(id, vsCurrencies);
        return bitcoinResponseDto = mapper.coingeckoSimplePriceToSimpleUseCaseDto(response);
    }



}

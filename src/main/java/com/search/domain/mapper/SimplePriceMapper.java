package com.search.domain.mapper;

import com.search.domain.modelDto.BitcoinResponseDto;
import com.search.gateway.coingeckoSupportedurrenciesImpl.model.CoingeckoSimplePriceResponse;

public class SimplePriceMapper {


    public BitcoinResponseDto coingeckoSimplePriceToSimpleUseCaseDto(CoingeckoSimplePriceResponse response) {
        BitcoinResponseDto bitcoinResponseDto = new BitcoinResponseDto();


        return bitcoinResponseDto;
    }


}

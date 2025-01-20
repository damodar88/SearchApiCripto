package com.search.domain.mapper;

import com.search.domain.modeldto.BitcoinResponseDto;
import com.search.gateway.coingeckosupportedurrenciesimpl.model.CoingeckoSimplePriceResponse;
import org.springframework.stereotype.Component;

@Component
public class SimplePriceMapper {


    public BitcoinResponseDto coingeckoSimplePriceToSimpleUseCaseDto(CoingeckoSimplePriceResponse response) {
        BitcoinResponseDto bitcoinResponseDto = new BitcoinResponseDto();


        return bitcoinResponseDto;
    }


}

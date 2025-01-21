package com.search.domain.mapper;

import com.search.domain.modeldto.BitcoinResponseDto;
import com.search.gateway.simplepricegatewayimpl.model.response.CoingeckoSimplePriceResponse;
import org.springframework.stereotype.Component;

@Component
public class SimplePriceMapper {


    public BitcoinResponseDto coingeckoSimplePriceToSimpleUseCaseDto(CoingeckoSimplePriceResponse response) {

        return new BitcoinResponseDto.Builder()
                .usd(response.getUsd())
                .build();

    }


}

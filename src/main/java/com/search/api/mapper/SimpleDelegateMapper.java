package com.search.api.mapper;

import com.search.api.model.SimplePriceResponse;
import com.search.domain.modeldto.BitcoinResponseDto;
import org.springframework.stereotype.Component;

@Component
public class SimpleDelegateMapper {

    public SimplePriceResponse simpleDelegateToBitcoinResponseDtoMapper(BitcoinResponseDto bitcoinResponseDto) {
        return new SimplePriceResponse.Builder()
                .usd(bitcoinResponseDto.getUsd())
                .build();
    }
}

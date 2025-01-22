package com.search.api.mapper;

import com.search.api.model.Bitcoin;
import com.search.api.model.SimplePriceResponse;
import com.search.domain.modeldto.BitcoinResponseDto;
import org.springframework.stereotype.Component;

@Component
public class SimpleDelegateMapper {

    public SimplePriceResponse simpleDelegateToBitcoinResponseDtoMapper(BitcoinResponseDto bitcoinResponseDto) {

        Bitcoin bitcoin = new Bitcoin.Builder()
                .usd(bitcoinResponseDto.getBitcoin().getUsd())
                .build();

        return new SimplePriceResponse.Builder()
                .bitcoin(bitcoin)
                .build();
    }
}

package com.search.domain.mapper;

import com.search.domain.modeldto.BitcoinDto;
import com.search.domain.modeldto.BitcoinResponseDto;
import com.search.data.model.coingecko.CoingeckoSimplePriceResponse;
import org.springframework.stereotype.Component;

@Component
public class SimplePriceMapper {


    public BitcoinResponseDto coingeckoSimplePriceToSimpleUseCaseDto(CoingeckoSimplePriceResponse response) {

        BitcoinDto bitcoinDto = new BitcoinDto.Builder()
                .usd(response.getBitcoin().getUsd())
                .build();

        return new BitcoinResponseDto.Builder()
                .bitcoin(bitcoinDto)
                .build();
    }


}

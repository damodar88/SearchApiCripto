package com.search.api.mapper;

import com.search.api.model.SimplePriceResponse;
import com.search.domain.modelDto.BitcoinResponseDto;

public class SimpleDelegateMapper {

    public SimplePriceResponse simpleDelegateToBitcoinResponseDtoMapper(BitcoinResponseDto bitcoinResponseDto) {
        SimplePriceResponse simplePriceResponse = new SimplePriceResponse();

        return simplePriceResponse;
    }


}

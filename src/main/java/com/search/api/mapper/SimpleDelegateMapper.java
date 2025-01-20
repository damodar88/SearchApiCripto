package com.search.api.mapper;

import com.search.api.model.SimplePriceResponse;
import com.search.domain.modeldto.BitcoinResponseDto;
import org.springframework.stereotype.Component;

@Component
public class SimpleDelegateMapper {

    public SimplePriceResponse simpleDelegateToBitcoinResponseDtoMapper(BitcoinResponseDto bitcoinResponseDto) {
        SimplePriceResponse simplePriceResponse = new SimplePriceResponse();

        return simplePriceResponse;
    }


}

package com.search.api.mapper;

import com.search.api.model.MarketPriceResponse;
import com.search.domain.modeldto.CryptoMarketPriceDomainDTO;
import org.springframework.stereotype.Component;

@Component
public class BitcoinDtoToPriceResponseMapper {

    public MarketPriceResponse simpleDelegateToBitcoinResponseDtoMapper(CryptoMarketPriceDomainDTO responseGeckoDto, CryptoMarketPriceDomainDTO responseBudaDto) {

        return null;
    }
}

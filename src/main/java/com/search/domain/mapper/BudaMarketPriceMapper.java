package com.search.domain.mapper;

import com.search.data.model.buda.CryptoPriceResponse;
import com.search.domain.modeldto.CryptoMarketPriceDomainDTO;
import com.search.domain.modeldto.MarketPriceDomainDTO;
import org.springframework.stereotype.Component;

import static com.search.common.constants.ApplicationConstants.BUDA_MARKET_ID;

@Component
public class BudaMarketPriceMapper {

    public CryptoMarketPriceDomainDTO mapBudaBitcoinPriceToDto(CryptoPriceResponse cryptoPriceResponse){


        new MarketPriceDomainDTO.Builder()
                .withPlatform(BUDA_MARKET_ID)
                .withPrice(Double.parseDouble(cryptoPriceResponse.getTicker().getLastPrice().get(0)))
                .withTimestamp(cryptoPriceResponse.getTicker().getMarketId())
                .build();


        return new CryptoMarketPriceDomainDTO.Builder()
                .withCryptoId(cryptoPriceResponse.getTicker().getMarketId())
                .withCurrency(cryptoPriceResponse.getTicker().getLastPrice())
                .withMarketPrices(cryptoPriceResponse.getTicker())
                .build();
    }
}

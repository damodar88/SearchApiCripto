package com.search.domain.mapper;

import com.search.common.exception.MapperException;
import com.search.data.model.buda.CryptoPriceResponse;
import com.search.domain.modeldto.CryptoMarketPriceDomainDTO;
import com.search.domain.modeldto.MarketPriceDomainDTO;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

import static com.search.common.constants.ApplicationConstants.BUDA_MARKET_ID;
import static com.search.common.constants.ErrorMessages.PRICE_NOT_FOUND_FOR_CURRENCY;

@Component
public class BudaMarketPriceMapper {

    public CryptoMarketPriceDomainDTO mapBudaBitcoinPriceToDto(CryptoPriceResponse cryptoPriceResponse){


        List<MarketPriceDomainDTO> marketPrice = Collections.singletonList(new MarketPriceDomainDTO.Builder()
                .withPlatform(BUDA_MARKET_ID)
                .withPrice(getPrice(cryptoPriceResponse))
                .withTimestamp(cryptoPriceResponse.getTicker().getMarketId())
                .build()
        );

        return new CryptoMarketPriceDomainDTO.Builder()
                .withCryptoId(cryptoPriceResponse.getTicker().getMarketId())
                .withCurrency(cryptoPriceResponse.getTicker().getMarketId())
                .withMarketPrices(marketPrice)
                .build();
    }


    private Double getPrice(CryptoPriceResponse cryptoPriceResponse){
        if (cryptoPriceResponse.getTicker().getLastPrice().isEmpty() || cryptoPriceResponse.getTicker().getLastPrice() == null){
            throw new MapperException(PRICE_NOT_FOUND_FOR_CURRENCY);
        }

        List<String> listPrice = Collections.singletonList(cryptoPriceResponse.getTicker().getLastPrice().get(0));
        return Double.parseDouble(listPrice.get(0));
    }
}

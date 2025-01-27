package com.search.domain.mapper;

import com.search.domain.modeldto.MarketPriceDomainDTO;
import com.search.domain.modeldto.CryptoMarketPriceDomainDTO;
import com.search.data.model.coingecko.CoingeckoSimplePriceResponse;
import org.springframework.stereotype.Component;

@Component
public class CoinGeckoMarketPriceMapper {


    public CryptoMarketPriceDomainDTO mapCoinGeckoBitcoinToDto(CoingeckoSimplePriceResponse response) {

        MarketPriceDomainDTO marketPriceDomainDTO = new MarketPriceDomainDTO.Builder()
                .usd(response.getBitcoin().getUsd())
                .build();

        return new CryptoMarketPriceDomainDTO.Builder()
                .bitcoin(marketPriceDomainDTO)
                .build();
    }
}

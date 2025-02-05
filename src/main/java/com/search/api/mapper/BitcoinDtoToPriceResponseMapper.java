package com.search.api.mapper;

import com.search.api.model.MarketPriceResponse;
import com.search.api.model.PlatformPrice;
import com.search.domain.modeldto.CryptoMarketPriceDomainDTO;
import com.search.domain.modeldto.MarketPriceDomainDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BitcoinDtoToPriceResponseMapper {

    public MarketPriceResponse simpleDelegateToBitcoinResponseDtoMapper(CryptoMarketPriceDomainDTO responseGeckoDto, CryptoMarketPriceDomainDTO responseBudaDto) {

        List<MarketPriceDomainDTO> marketGeckoPrices = Optional.ofNullable(responseGeckoDto.getMarketPrices())
                .orElseThrow(() -> new IllegalArgumentException("⚠️ No se encontraron precios en CoinGecko."));

        List<PlatformPrice> prices = new ArrayList<>();

        for (MarketPriceDomainDTO marketPriceDomainDTO : marketGeckoPrices) {
            PlatformPrice platformPrice = new PlatformPrice.Builder()
                    .plataform(marketPriceDomainDTO.getPlatform())
                    .price(marketPriceDomainDTO.getPrice())
                    .timestamp(marketPriceDomainDTO.getTimestamp())
                    .build();
            prices.add(platformPrice);
        }

        return new MarketPriceResponse.Builder()
                .cryptoId(responseGeckoDto.getCryptoId())
                .currency(responseGeckoDto.getCurrency())
                .prices(prices)
                .build();
    }
}

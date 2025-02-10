package com.search.api.mapper;

import com.search.api.model.MarketPriceResponse;
import com.search.api.model.PlatformPrice;
import com.search.domain.modeldto.CryptoMarketPriceDomainDTO;
import com.search.domain.modeldto.MarketPriceDomainDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Component
public class BitcoinDtoToPriceResponseMapper {

    public MarketPriceResponse simpleDelegateToBitcoinResponseDtoMapper(CryptoMarketPriceDomainDTO responseGeckoDto, CryptoMarketPriceDomainDTO responseBudaDto) {

        MarketPriceResponse coinGeckoResponse =mapGeckoDtoToPlatformPrices(responseGeckoDto);


        return null;
    }



    private MarketPriceResponse mapGeckoDtoToPlatformPrices(CryptoMarketPriceDomainDTO responseGeckoDto){
        List<MarketPriceDomainDTO> marketGeckoPrices = Optional.ofNullable(responseGeckoDto.getMarketPrices())
                .orElseThrow(() -> new IllegalArgumentException("⚠️ No se encontraron precios en CoinGecko."));

        List<PlatformPrice> prices = marketGeckoPrices.stream()
                .map(marketGeckoPricesDTO -> new PlatformPrice.Builder()
                        .plataform(marketGeckoPricesDTO.getPlatform())
                        .price(marketGeckoPricesDTO.getPrice())
                        .timestamp(marketGeckoPricesDTO.getTimestamp())
                        .build())
                .collect(Collectors.toList());

        return new MarketPriceResponse.Builder()
                .cryptoId(responseGeckoDto.getCryptoId())
                .currency(responseGeckoDto.getCurrency())
                .prices(prices)
                .build();
    }
}




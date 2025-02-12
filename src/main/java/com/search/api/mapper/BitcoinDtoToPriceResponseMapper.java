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

@Component
public class BitcoinDtoToPriceResponseMapper {

    public MarketPriceResponse simpleDelegateToBitcoinResponseDtoMapper(CryptoMarketPriceDomainDTO responseGeckoDto, CryptoMarketPriceDomainDTO responseBudaDto) {

        List<PlatformPrice> geckoPrices = requestToPlatformPriceMap(responseGeckoDto, "CoinGecko");
        List<PlatformPrice> budaPrices = requestToPlatformPriceMap(responseBudaDto, "Buda.com");

        List<PlatformPrice> allPrices = new ArrayList<>();
        allPrices.addAll(geckoPrices);
        allPrices.addAll(budaPrices);

        String cryptoId = Optional.ofNullable(responseGeckoDto)
                .map(CryptoMarketPriceDomainDTO::getCryptoId)
                .orElse(Optional.ofNullable(responseBudaDto).map(CryptoMarketPriceDomainDTO::getCryptoId).orElse("unknown"));

        String currency = Optional.ofNullable(responseGeckoDto)
                .map(CryptoMarketPriceDomainDTO::getCurrency)
                .orElse(Optional.ofNullable(responseBudaDto).map(CryptoMarketPriceDomainDTO::getCurrency).orElse("unknown"));

        return new MarketPriceResponse.Builder()
                .cryptoId(cryptoId)
                .currency(currency)
                .prices(allPrices)
                .build();
    }

    private List<PlatformPrice> requestToPlatformPriceMap(CryptoMarketPriceDomainDTO responseDto, String platformName) {
        List<MarketPriceDomainDTO> marketPricesList = Optional.ofNullable(responseDto.getMarketPrices())
                .orElseGet(ArrayList::new);

        return marketPricesList.stream()
                .map(price -> new PlatformPrice.Builder()
                        .plataform(platformName)
                        .price(price.getPrice())
                        .timestamp(price.getTimestamp())
                        .build())
                .collect(Collectors.toList());
    }
}




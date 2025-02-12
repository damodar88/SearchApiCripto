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
        List<PlatformPrice> geckoPrices = mapGeckoDtoToPlatformPrices(responseGeckoDto);
        List<PlatformPrice> budaPrices = mapBudaDtoToPlatformPrices(responseBudaDto);

        List<PlatformPrice> allPrices = new ArrayList<>();
        allPrices.addAll(geckoPrices);
        allPrices.addAll(budaPrices);

        return new MarketPriceResponse.Builder()
                .cryptoId(responseGeckoDto.getCryptoId())
                .currency(responseGeckoDto.getCurrency())
                .prices(allPrices)
                .build();
    }

    private List<PlatformPrice> mapGeckoDtoToPlatformPrices(CryptoMarketPriceDomainDTO responseGeckoDto) {
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
        return prices;
    }

    private List<PlatformPrice> mapBudaDtoToPlatformPrices(CryptoMarketPriceDomainDTO responseBudaDto) {
        List<MarketPriceDomainDTO> marketBudaPrices = Optional.ofNullable(responseBudaDto.getMarketPrices())
                .orElseThrow(() -> new IllegalArgumentException("⚠️ No se encontraron precios en Buda."));

        List<PlatformPrice> prices = new ArrayList<>();
        for (MarketPriceDomainDTO marketPriceDomainDTO : marketBudaPrices) {
            PlatformPrice platformPrice = new PlatformPrice.Builder()
                    .plataform(marketPriceDomainDTO.getPlatform())
                    .price(marketPriceDomainDTO.getPrice())
                    .timestamp(marketPriceDomainDTO.getTimestamp())
                    .build();
            prices.add(platformPrice);
        }
        return prices;
    }
}




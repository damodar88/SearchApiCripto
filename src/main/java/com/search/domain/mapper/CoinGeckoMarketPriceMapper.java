package com.search.domain.mapper;

import com.search.data.model.coingecko.CryptoModel;
import com.search.domain.modeldto.CryptoMarketPriceDomainDTO;
import com.search.data.model.coingecko.CoinGeckoCryptoResponse;
import com.search.domain.modeldto.MarketPriceDomainDTO;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CoinGeckoMarketPriceMapper {

    private static final String PLATFORM_NAME = "CoinGecko";
    private static final DateTimeFormatter TIMESTAMP_FORMATTER =  DateTimeFormatter.ISO_INSTANT.withZone(ZoneOffset.UTC);

    public CryptoMarketPriceDomainDTO mapCoinGeckoBitcoinToDto(CoinGeckoCryptoResponse response) {
        if (response == null || response.getCryptos().isEmpty()) {
            return null;
        }

        Map.Entry<String, CryptoModel> entry = response.getCryptos().entrySet().iterator().next();
        CryptoModel cryptoModel = entry.getValue();

        return new CryptoMarketPriceDomainDTO.Builder()
                .withCryptoId(entry.getKey())
                .withCurrency(String.valueOf(cryptoModel.getUsd()))
                .withMarketPrices(Collections.singletonList(
                        new MarketPriceDomainDTO.Builder()
                                .withPlatform(PLATFORM_NAME)
                                .withPrice(cryptoModel.getUsd())
                                .withTimestamp(formatTimestamp(cryptoModel.getLastUpdatedAt()))
                                .build()
                ))
                .build();
    }

    private String formatTimestamp(long epochSeconds) {
        return Instant.ofEpochSecond(epochSeconds)
                .atOffset(ZoneOffset.UTC)
                .format(TIMESTAMP_FORMATTER);
    }
}

package com.search.domain.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.search.common.exception.MapperException;
import com.search.data.model.coingecko.CryptoPriceModel;
import com.search.domain.modeldto.CryptoMarketPriceDomainDTO;
import com.search.data.model.coingecko.CoinGeckoCryptoResponse;
import com.search.domain.modeldto.MarketPriceDomainDTO;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.search.common.constants.ErrorMessages.CRYPTO_NOT_FOUND;
import static com.search.common.constants.ErrorMessages.PRICE_NOT_FOUND;

@Component
public class CoinGeckoMarketPriceMapper {


    private static final String PLATFORM_NAME = "CoinGecko";
    private static final DateTimeFormatter TIMESTAMP_FORMATTER =
            DateTimeFormatter.ISO_INSTANT.withZone(ZoneOffset.UTC);

    public CryptoMarketPriceDomainDTO mapCoinGeckoBitcoinToDto(CoinGeckoCryptoResponse response, String cryptoCurrency, String selectedCurrency) {

        CryptoPriceModel cryptoData = Optional.ofNullable(response.getCryptos().get(cryptoCurrency))
                .orElseThrow(() -> new MapperException(CRYPTO_NOT_FOUND + cryptoCurrency));

        Double price = Optional.ofNullable(cryptoData.getPrices().get(selectedCurrency))
                .orElseThrow(() -> new MapperException(PRICE_NOT_FOUND + selectedCurrency));

        long timestampEpoch = cryptoData.getLastUpdatedAt();
        String timestamp = timestampEpoch > 0
                ? TIMESTAMP_FORMATTER.format(Instant.ofEpochSecond(timestampEpoch))
                : "N/A";

        List<MarketPriceDomainDTO> marketPrices = Collections.singletonList(
                new MarketPriceDomainDTO.Builder()
                        .withPlatform(PLATFORM_NAME)
                        .withPrice(price)
                        .withTimestamp(timestamp)
                        .build()
        );

        return new CryptoMarketPriceDomainDTO.Builder()
                .withCryptoId(cryptoCurrency)
                .withCurrency(selectedCurrency)
                .withMarketPrices(marketPrices)
                .build();
    }

}

package com.search.domain.mapper;

import com.search.common.exception.MapperException;
import com.search.data.model.coingecko.CryptoPriceModel;
import com.search.domain.modeldto.CryptoMarketPriceDomainDTO;
import com.search.data.model.coingecko.CoinGeckoCryptoResponse;
import com.search.domain.modeldto.MarketPriceDomainDTO;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.search.common.constants.ApplicationConstants.PLATFORM_NAME;
import static com.search.common.constants.ApplicationConstants.TIMESTAMP_FORMATTER;
import static com.search.common.constants.ErrorMessages.CRYPTO_NOT_FOUND;
import static com.search.common.constants.ErrorMessages.PRICE_NOT_FOUND;

@Component
public class CoinGeckoMarketPriceMapper {

    public CryptoMarketPriceDomainDTO mapCoinGeckoBitcoinToDto(CoinGeckoCryptoResponse response, String cryptoCurrency,
                                                               String selectedCurrency) {

        CryptoPriceModel cryptoData = getCryptoData(response, cryptoCurrency);
        Double price = getPrice(cryptoData, selectedCurrency);

        long timestampEpoch = cryptoData.getLastUpdatedAt();

        return new CryptoMarketPriceDomainDTO.Builder()
                .withCryptoId(cryptoCurrency)
                .withCurrency(selectedCurrency)
                .withMarketPrices(getMarketPricesList(getTimeStamp(timestampEpoch), price))
                .build();
    }

    private String getTimeStamp(long timestampEpoch){
        return timestampEpoch > 0
                ? TIMESTAMP_FORMATTER.format(Instant.ofEpochSecond(timestampEpoch))
                : "N/A";
    }

    private CryptoPriceModel getCryptoData(CoinGeckoCryptoResponse response, String cryptoCurrency) {
        return Optional.ofNullable(response.getCryptos().get(cryptoCurrency))
                .orElseThrow(() -> new MapperException(CRYPTO_NOT_FOUND + cryptoCurrency));
    }

    private Double getPrice(CryptoPriceModel cryptoData, String selectedCurrency) {
        return Optional.ofNullable(cryptoData.getPrices().get(selectedCurrency))
                .orElseThrow(() -> new MapperException(PRICE_NOT_FOUND + selectedCurrency));
    }

    private List<MarketPriceDomainDTO> getMarketPricesList(String timestamp, Double price){
        return Collections.singletonList(
                new MarketPriceDomainDTO.Builder()
                        .withPlatform(PLATFORM_NAME)
                        .withPrice(price)
                        .withTimestamp(timestamp)
                        .build()
        );
    }
}

package com.search.domain.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.search.data.model.coingecko.CryptoPriceModel;
import com.search.domain.modeldto.CryptoMarketPriceDomainDTO;
import com.search.data.model.coingecko.CoinGeckoCryptoResponse;
import com.search.domain.modeldto.MarketPriceDomainDTO;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Map;

@Component
public class CoinGeckoMarketPriceMapper {


    private static final String PLATFORM_NAME = "CoinGecko";
    private static final DateTimeFormatter TIMESTAMP_FORMATTER =
            DateTimeFormatter.ISO_INSTANT.withZone(ZoneOffset.UTC);

    public CryptoMarketPriceDomainDTO mapCoinGeckoBitcoinToDto(CoinGeckoCryptoResponse response, String cryptoCurrency, String selectedCurrency) {

        // Extraer los datos de la criptomoneda desde la respuesta
        CryptoPriceModel cryptoData = response.getCryptos().get(cryptoCurrency);
        if (cryptoData == null) {
            throw new IllegalArgumentException("No se encontraron datos para la criptomoneda: " + cryptoCurrency);
        }

        // Obtener el precio en la moneda seleccionada
        Double price = cryptoData.getPrices().get(selectedCurrency);
        if (price == null) {
            throw new IllegalArgumentException("No se encontró precio para la moneda: " + selectedCurrency);
        }

        // Obtener la marca de tiempo y convertirla a formato ISO
        long timestampEpoch = cryptoData.getLastUpdatedAt();
        String timestamp = timestampEpoch > 0
                ? TIMESTAMP_FORMATTER.format(Instant.ofEpochSecond(timestampEpoch))
                : "N/A";

        // Crear lista de precios de mercado
        List<MarketPriceDomainDTO> marketPrices = Collections.singletonList(
                new MarketPriceDomainDTO.Builder()
                        .platform(PLATFORM_NAME)
                        .price(price)
                        .timestamp(timestamp)
                        .build()
        );

        // Construir el DTO intermedio
        return new CryptoMarketPriceDomainDTO.Builder()
                .cryptoId(cryptoCurrency)
                .currency(selectedCurrency)
                .marketPrices(marketPrices)
                .build();
    }

}

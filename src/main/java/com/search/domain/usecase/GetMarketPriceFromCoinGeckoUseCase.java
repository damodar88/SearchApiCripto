package com.search.domain.usecase;

import com.search.domain.mapper.CoinGeckoMarketPriceMapper;
import com.search.domain.modeldto.CryptoMarketPriceDomainDTO;
import com.search.data.gateway.CoinGeckoApiGateway;
import com.search.data.model.coingecko.CoingeckoSimplePriceResponse;
import org.springframework.stereotype.Service;

@Service
public class GetMarketPriceFromCoinGeckoUseCase {

    private final CoinGeckoApiGateway gateway;

    private final CoinGeckoMarketPriceMapper mapper;

    public GetMarketPriceFromCoinGeckoUseCase(CoinGeckoApiGateway gateway, CoinGeckoMarketPriceMapper mapper) {
        this.gateway = gateway;
        this.mapper = mapper;
    }

    public CryptoMarketPriceDomainDTO getBitcoinPrice(String id, String vsCurrencies) {
        CoingeckoSimplePriceResponse response = gateway.getSimplePrice(id, vsCurrencies);
        return  mapper.mapCoinGeckoBitcoinToDto(response);
    }
}

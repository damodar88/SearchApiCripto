package com.search.data.gatewayimpl;

import com.search.data.gateway.CoinGeckoApiGateway;
import com.search.data.model.coingecko.CoinGeckoCryptoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CoinGeckoApiGatewayImpl implements CoinGeckoApiGateway {

    private final RestTemplate restTemplate;

    @Value("${url.coingecko.simpleprice}")
    private String urlCoingeckoSimplePrice;

    public CoinGeckoApiGatewayImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CoinGeckoCryptoResponse getSimplePrice(String id, String currency) {
        String url = urlCoingeckoSimplePrice + "?ids=" + id + "&vs_currencies=" + currency;
        return restTemplate.getForObject(url, CoinGeckoCryptoResponse.class);
    }
}

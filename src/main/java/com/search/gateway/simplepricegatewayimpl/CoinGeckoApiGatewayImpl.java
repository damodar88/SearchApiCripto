package com.search.gateway.simplepricegatewayimpl;

import com.search.gateway.CoinGeckoApiGateway;
import com.search.gateway.simplepricegatewayimpl.model.response.CoingeckoSimplePriceResponse;
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
    public CoingeckoSimplePriceResponse getSimplePrice(String id, String currency) {
        String url = urlCoingeckoSimplePrice + "?ids=" + id + "&vs_currencies=" + currency;
        return restTemplate.getForObject(url, CoingeckoSimplePriceResponse.class);
    }
}

package com.search.data.client;


import com.search.data.model.buda.MarketTickerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "budaApiClient", url = "https://api.buda.com")
public interface BudaApiClient {

    @GetMapping("/v2/markets/{market_id}/ticker")
    MarketTickerResponse getMarketTicker(@PathVariable("market_id") String marketId);

}

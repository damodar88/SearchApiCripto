package com.search.data.gateway;

import com.search.data.model.buda.MarketTickerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "budaApiClient", url = "https://api.buda.com")
public interface BudaApiGateway {

     @GetMapping("/v2/markets/ticker")
     MarketTickerResponse getMarketTicker(@RequestParam("market_id") String marketId);
}

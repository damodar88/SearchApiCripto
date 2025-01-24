package com.search.data.gateway;

import com.search.data.model.buda.MarketTickerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interface that defines the methods to interact with the Buda API
 */
public interface BudaApiGateway {

     /**
      * @param marketId The market id
      * @return MarketTickerResponse object with the market price cryptocurrency information
      */
     MarketTickerResponse getMarketTicker(String marketId);
}

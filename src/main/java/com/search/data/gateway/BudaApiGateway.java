package com.search.data.gateway;

import com.search.data.model.buda.CryptoPriceResponse;

/**
 * Interface that defines the methods to interact with the Buda API
 */
public interface BudaApiGateway {

     /**
      * @param marketId The market id
      * @return MarketTickerResponse object with the market price cryptocurrency information
      */
     CryptoPriceResponse getMarketTicker(String marketId);
}

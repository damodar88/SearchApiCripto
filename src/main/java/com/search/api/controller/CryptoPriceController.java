package com.search.api.controller;

import com.search.api.model.MarketPriceResponse;

public interface CryptoPriceController {

    MarketPriceResponse getBitcoinPriceFromCoingeckoo(String cryptoCurrency, String vsCurrencies);

}

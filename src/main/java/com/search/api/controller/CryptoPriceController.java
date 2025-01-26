package com.search.api.controller;

import com.search.api.model.SimplePriceResponse;

public interface CryptoPriceController {

    SimplePriceResponse getBitcoinPriceFromCoingeckoo(String cryptoCurrency, String vsCurrencies);

}

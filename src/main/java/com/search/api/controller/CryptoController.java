package com.search.api.controller;

import com.search.api.model.SimplePriceResponse;

public interface CryptoController {
    public SimplePriceResponse getSimplePrice(String id, String vsCurrencies);

}

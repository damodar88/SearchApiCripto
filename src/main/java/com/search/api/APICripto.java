package com.search.api;


import com.search.dao.CriptoCurrencies;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

@Headers("Accept: application/json")
public interface APICripto {

    @RequestLine("GET /markets")
    List<CriptoCurrencies> getCryptoCurrencies(@QueryMap Map<String, Object> queryMap);

}

package com.search.api;


import com.search.dao.CryptoCurrencies;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

@Headers("Accept: application/json")
public interface JobsAPI {

    @RequestLine("GET /markets")
    List<CryptoCurrencies> getCryptoCurrencies(@QueryMap Map<String, Object> queryMap);

}

package com.search.api.controller;

import feign.Feign;
import feign.gson.GsonDecoder;

public interface APIFunctions {

    static <T>  T builtApi(Class<T> clazz, String url){
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(clazz, url);
    }


}

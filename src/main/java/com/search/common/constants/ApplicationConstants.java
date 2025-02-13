package com.search.common.constants;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class ApplicationConstants {

    private ApplicationConstants() {
    }


    public static final String BUDA_MARKET_ID = "Buda";
    public static final String PLATFORM_NAME = "CoinGecko";
    public static final DateTimeFormatter TIMESTAMP_FORMATTER =
            DateTimeFormatter.ISO_INSTANT.withZone(ZoneOffset.UTC);
}

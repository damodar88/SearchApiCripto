package com.search.common.constants;

public class ErrorMessages {

    public static final String CRYPTO_NOT_FOUND = "No information found for the currency: ";
    public static final String PRICE_NOT_FOUND = "No price found for the currency: ";
    public static final String PRICE_NOT_FOUND_FOR_CURRENCY = "No price found for the currency: ";

    private ErrorMessages() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

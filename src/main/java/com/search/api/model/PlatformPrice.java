package com.search.api.model;

public class PlatformPrice {

    private final String platform;
    private final Double price;
    private final String timestamp;

    private PlatformPrice(Builder build){
        this.platform = build.platform;
        this.price = build.price;
        this.timestamp = build.timestamp;
    }

    public String getPlatform() {
        return platform;
    }

    public Double getPrice() {
        return price;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public static class Builder{
        private String platform;
        private Double price;
        private String timestamp;

        public Builder plataform(String platform){
            this.platform = platform;
            return this;
        }

        public Builder price(Double price){
            this.price = price;
            return this;
        }

        public Builder timestamp(String timestamp){
            this.timestamp = timestamp;
            return this;
        }

        public PlatformPrice build() {
            if (platform == null || platform.trim().isEmpty()) {
                throw new IllegalArgumentException("⚠️ El campo 'platform' es obligatorio.");
            }
            if (price == null || price < 0) {
                throw new IllegalArgumentException("⚠️ El 'price' no puede ser nulo ni negativo.");
            }
            if (timestamp == null || timestamp.trim().isEmpty()) {
                throw new IllegalArgumentException("⚠️ El 'timestamp' no puede estar vacío.");
            }

            return new PlatformPrice(this);
        }
    }
}

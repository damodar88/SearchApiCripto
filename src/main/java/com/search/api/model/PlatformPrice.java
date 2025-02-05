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

        public PlatformPrice build(){
            return new PlatformPrice(this);
        }
    }
}

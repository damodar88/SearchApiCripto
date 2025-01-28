package com.search.domain.modeldto;

public class MarketPriceDomainDTO {

    private String platform;
    private Double price;
    private String timestamp;


    private MarketPriceDomainDTO(Builder build){
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

        public Builder withPlatform(String platform) {
            this.platform = platform;
            return this;
        }

        public Builder withPrice(Double price) {
            this.price = price;
            return this;
        }

        public Builder withTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public MarketPriceDomainDTO build(){
            return new MarketPriceDomainDTO(this);
        }
    }

}

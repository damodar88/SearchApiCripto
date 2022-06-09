package com.search.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class CryptoCurrencies {

    public String id;
    public String name;
    public String base_currency;
    public String quote_currency;

    @SerializedName("minimum_order_amount")
    List<MinimumOrderAmount> minimum_order_amount;

    public boolean disabled;
    public boolean illiquid;

    @SerializedName("rpo_disabled")
    public String rpoDisabled;

    @SerializedName("taker_fee")
    public Double takerFee;

    @SerializedName("maker_fee")
    public Double makerFee;

    @SerializedName("max_orders_per_minute")
    public Double maxOrdersPerMinute;

    @SerializedName("maker_discount_percentage")
    public Double makerDiscountPercentage;

    @SerializedName("taker_discount_percentage")
    public Double takerDiscountPercentage;


    public CryptoCurrencies() {
    }

    public CryptoCurrencies(String id, String name, String base_currency, String quote_currency, List<MinimumOrderAmount> minimum_order_amount, boolean disabled, boolean illiquid, String rpoDisabled, Double takerFee, Double makerFee, Double maxOrdersPerMinute, Double makerDiscountPercentage, Double takerDiscountPercentage) {
        this.id = id;
        this.name = name;
        this.base_currency = base_currency;
        this.quote_currency = quote_currency;
        this.minimum_order_amount = minimum_order_amount;
        this.disabled = disabled;
        this.illiquid = illiquid;
        this.rpoDisabled = rpoDisabled;
        this.takerFee = takerFee;
        this.makerFee = makerFee;
        this.maxOrdersPerMinute = maxOrdersPerMinute;
        this.makerDiscountPercentage = makerDiscountPercentage;
        this.takerDiscountPercentage = takerDiscountPercentage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase_currency() {
        return base_currency;
    }

    public void setBase_currency(String base_currency) {
        this.base_currency = base_currency;
    }

    public String getQuote_currency() {
        return quote_currency;
    }

    public void setQuote_currency(String quote_currency) {
        this.quote_currency = quote_currency;
    }

    public List<MinimumOrderAmount> getMinimum_order_amount() {
        return minimum_order_amount;
    }

    public void setMinimum_order_amount(List<MinimumOrderAmount> minimum_order_amount) {
        this.minimum_order_amount = minimum_order_amount;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isIlliquid() {
        return illiquid;
    }

    public void setIlliquid(boolean illiquid) {
        this.illiquid = illiquid;
    }

    public String getRpoDisabled() {
        return rpoDisabled;
    }

    public void setRpoDisabled(String rpoDisabled) {
        this.rpoDisabled = rpoDisabled;
    }

    public Double getTakerFee() {
        return takerFee;
    }

    public void setTakerFee(Double takerFee) {
        this.takerFee = takerFee;
    }

    public Double getMakerFee() {
        return makerFee;
    }

    public void setMakerFee(Double makerFee) {
        this.makerFee = makerFee;
    }

    public Double getMaxOrdersPerMinute() {
        return maxOrdersPerMinute;
    }

    public void setMaxOrdersPerMinute(Double maxOrdersPerMinute) {
        this.maxOrdersPerMinute = maxOrdersPerMinute;
    }

    public Double getMakerDiscountPercentage() {
        return makerDiscountPercentage;
    }

    public void setMakerDiscountPercentage(Double makerDiscountPercentage) {
        this.makerDiscountPercentage = makerDiscountPercentage;
    }

    public Double getTakerDiscountPercentage() {
        return takerDiscountPercentage;
    }

    public void setTakerDiscountPercentage(Double takerDiscountPercentage) {
        this.takerDiscountPercentage = takerDiscountPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CryptoCurrencies that = (CryptoCurrencies) o;
        return disabled == that.disabled && illiquid == that.illiquid && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(base_currency, that.base_currency) && Objects.equals(quote_currency, that.quote_currency) && Objects.equals(minimum_order_amount, that.minimum_order_amount) && Objects.equals(rpoDisabled, that.rpoDisabled) && Objects.equals(takerFee, that.takerFee) && Objects.equals(makerFee, that.makerFee) && Objects.equals(maxOrdersPerMinute, that.maxOrdersPerMinute) && Objects.equals(makerDiscountPercentage, that.makerDiscountPercentage) && Objects.equals(takerDiscountPercentage, that.takerDiscountPercentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, base_currency, quote_currency, minimum_order_amount, disabled, illiquid, rpoDisabled, takerFee, makerFee, maxOrdersPerMinute, makerDiscountPercentage, takerDiscountPercentage);
    }

    @Override
    public String toString() {
        return "CryptoCurrencies{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", base_currency='" + base_currency + '\'' +
                ", quote_currency='" + quote_currency + '\'' +
                ", minimum_order_amount=" + minimum_order_amount +
                ", disabled=" + disabled +
                ", illiquid=" + illiquid +
                ", rpoDisabled='" + rpoDisabled + '\'' +
                ", takerFee=" + takerFee +
                ", makerFee=" + makerFee +
                ", maxOrdersPerMinute=" + maxOrdersPerMinute +
                ", makerDiscountPercentage=" + makerDiscountPercentage +
                ", takerDiscountPercentage=" + takerDiscountPercentage +
                '}';
    }
}

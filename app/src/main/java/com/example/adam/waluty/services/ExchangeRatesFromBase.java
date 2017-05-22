package com.example.adam.waluty.services;

/**
 * Created by adam on 13.05.17.
 */

import com.example.adam.waluty.CurrencyCodesEnum;
import com.example.adam.waluty.DateHelpers;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Map;

public class ExchangeRatesFromBase {

    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("rates")
    @Expose
    private Map<String,Double> rates;

    public Double getRate(CurrencyCodesEnum code) {
        return rates.get(code.name());
    }

    public CurrencyCodesEnum getBase() {
        return CurrencyCodesEnum.valueOf(base);
    }

    public Date getDate() {
        return DateHelpers.stringToDate(date);
    }
}
package com.example.adam.waluty.services;

/**
 * Created by adam on 13.05.17.
 */

import com.example.adam.waluty.Rates;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExchangeRatesFromBase {

    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("rates")
    @Expose
    private Rates rates;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }
}
package com.example.adam.waluty;

/**
 * Created by adam on 13.05.17.
 */

public class CurrencyModel {
    private CurrencyCodesEnum currencyCodeEnum;
    private int changeImage;
    private String exchangeRate;

    public CurrencyCodesEnum getCurrencyCodeEnum() {
        return currencyCodeEnum;
    }

    CurrencyModel(CurrencyCodesEnum currency){
        currencyCodeEnum = currency;
    }

    public int getCountryName() {
        return currencyCodeEnum.getCountryName();
    }

    public int getCurrencyName() {
        return currencyCodeEnum.getCurrencyName();
    }

    public int getFlagImage() {
        return currencyCodeEnum.getFlag();
    }

    public int getChangeImage() {
        return changeImage;
    }

    public void setChangeImage(int changeImage) {
        this.changeImage = changeImage;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}

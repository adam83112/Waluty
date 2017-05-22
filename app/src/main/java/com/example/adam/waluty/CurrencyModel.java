package com.example.adam.waluty;

/**
 * Created by adam on 13.05.17.
 */

public class CurrencyModel {
    private int countryName;
    private int currencyName;
    private int flagImage;
    private int changeImage;
    private String exchangeRate;

    CurrencyModel(CurrencyCodesEnum currency){
        this.countryName = currency.getCountryName();
        this.currencyName = currency.getCurrencyName();
        this.flagImage = currency.getFlag();
    }

    public int getCountryName() {
        return countryName;
    }

    public int getCurrencyName() {
        return currencyName;
    }

    public int getFlagImage() {
        return flagImage;
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

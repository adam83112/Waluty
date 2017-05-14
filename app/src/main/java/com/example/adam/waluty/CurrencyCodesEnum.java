package com.example.adam.waluty;

/**
 * Created by adam on 06.05.17.
 */

public enum CurrencyCodesEnum {
    AUD(R.drawable.australia, R.string.australia_country_name, R.string.australia_currency_name),
    BGN(R.drawable.bulgaria, R.string.bulgaria_country_name, R.string.bulgaria_currency_name),
    BRL(R.drawable.brazil, R.string.brazil_country_name, R.string.brazil_currency_name),
    CAD(R.drawable.canada, R.string.canada_country_name, R.string.canada_currency_name),
    CHF(R.drawable.switzerland, R.string.switzerland_country_name, R.string.switzerland_currency_name),
    CNY(R.drawable.china, R.string.china_country_name, R.string.china_currency_name),
    CZK(R.drawable.czech_republic, R.string.czech_republic_country_name, R.string.czech_republic_currency_name),
    DKK(R.drawable.denmark, R.string.denmark_country_name, R.string.denmark_currency_name),
    EUR(R.drawable.european_union, R.string.european_union_country_name, R.string.european_union_currency_name),
    GBP(R.drawable.united_kingdom, R.string.united_kingdom_country_name, R.string.united_kingdom_currency_name),
    HKD(R.drawable.hong_kong, R.string.hong_kong_country_name, R.string.hong_kong_currency_name),
    HRK(R.drawable.croatia, R.string.croatia_country_name, R.string.croatia_currency_name),
    HUF(R.drawable.hungary, R.string.hungary_country_name, R.string.hungary_currency_name),
    IDR(R.drawable.indonesia, R.string.indonesia_country_name, R.string.indonesia_currency_name),
    ILS(R.drawable.israel, R.string.israel_country_name, R.string.israel_currency_name),
    INR(R.drawable.india, R.string.india_country_name, R.string.india_currency_name),
    JPY(R.drawable.japan, R.string.japan_country_name, R.string.japan_currency_name),
    KRW(R.drawable. south_korea, R.string.south_korea_country_name, R.string.south_korea_currency_name),
    MXN(R.drawable.mexico, R.string.mexico_country_name, R.string.mexico_currency_name),
    MYR(R.drawable.malasya, R.string.malasya_country_name, R.string.malasya_currency_name),
    NOK(R.drawable.norway, R.string.norway_country_name, R.string.norway_currency_name),
    NZD(R.drawable.new_zealand, R.string.new_zealand_country_name, R.string.new_zealand_currency_name),
    PHP(R.drawable.philippines, R.string.philippines_country_name, R.string.philippines_currency_name),
    PLN(R.drawable.poland, R.string.poland_country_name, R.string.poland_currency_name),
    RON(R.drawable.romania, R.string.romania_country_name, R.string.romania_currency_name),
    RUB(R.drawable.russia, R.string.russia_country_name, R.string.russia_currency_name),
    SEK(R.drawable.sweden, R.string.sweden_country_name, R.string.sweden_currency_name),
    SGD(R.drawable.singapore, R.string.singapore_country_name, R.string.singapore_currency_name),
    THB(R.drawable.thailand, R.string.thailand_country_name, R.string.thailand_currency_name),
    TRY(R.drawable.turkey, R.string.turkey_country_name, R.string.turkey_currency_name),
    USD(R.drawable.united_states, R.string.united_states_country_name, R.string.united_states_currency_name),
    ZAR(R.drawable.south_africa, R.string.south_africa_country_name, R.string.south_africa_currency_name);

    private int flag;
    private int countryName;
    private int currencyName;


    CurrencyCodesEnum(int flag, int countryName, int currencyName) {
        this.flag = flag;
        this.countryName = countryName;
        this.currencyName = currencyName;
    }

    public int getFlag() {
        return flag;
    }

    public int getCountryName() {
        return countryName;
    }

    public int getCurrencyName() {
        return currencyName;
    }

}
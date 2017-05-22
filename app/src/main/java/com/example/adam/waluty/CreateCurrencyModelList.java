package com.example.adam.waluty;

import com.example.adam.waluty.services.ExchangeRatesFromBase;

import java.util.ArrayList;

/**
 * Created by adam on 14.05.17.
 */

public class CreateCurrencyModelList {
    public static ArrayList<CurrencyModel> getList(ExchangeRatesFromBase todayRates, ExchangeRatesFromBase previousRates){
        ArrayList<CurrencyModel> currencyList = new ArrayList<>();
        for (CurrencyCodesEnum currency : CurrencyCodesEnum.values()) {
            Double todayRate = todayRates.getRate(currency);
            Double previousRate = previousRates.getRate(currency);
            if(currency == todayRates.getBase()) {
                continue;
            }

            CurrencyModel currencyModel = new CurrencyModel(currency);
            currencyModel.setChangeImage(getTrending(todayRate, previousRate));
            currencyModel.setExchangeRate(formatExchangeRate(todayRate, currency));
            currencyList.add(currencyModel);
        }
        return currencyList;
    }

    private static int getTrending(Double todayRate, Double previousRate){
        Double change = todayRate - previousRate;
        if(change > 0) {
            return R.drawable.trending_up;
        }
        else if(change < 0) {
            return R.drawable.trending_down;
        }
        else {
            return R.drawable.trending_flat;
        }
    }

    private static String formatExchangeRate(Double rate, CurrencyCodesEnum currency){
        return String.format("%1$.3f", rate) + " " + currency.name();
    }
}

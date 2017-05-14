package com.example.adam.waluty;

import com.example.adam.waluty.services.ExchangeRatesFromBase;

import java.util.ArrayList;

/**
 * Created by adam on 14.05.17.
 */

public class CreateCurrencyModelList {
    public static ArrayList<CurrencyModel> getList(ExchangeRatesFromBase todayRates, ExchangeRatesFromBase previousRates){
        ArrayList<CurrencyModel> currencyList = new ArrayList<>();
        for (CurrencyCodesEnum c : CurrencyCodesEnum.values()) {
            Double todayRate = getRate(todayRates.getRates(), c);
            Double previousRate = getRate(previousRates.getRates(), c);
            if(todayRate == null) continue;

            CurrencyModel currency = new CurrencyModel();
            currency.countryName = c.getCountryName();
            currency.currencyName = c.getCurrencyName();
            currency.flag_image = c.getFlag();

            Double change = todayRate - previousRate;
            if(change > 0) currency.change_image = R.drawable.trending_up;
            else if(change < 0) currency.change_image = R.drawable.trending_down;
            else currency.change_image = R.drawable.trending_flat;

            String value = String.format("%1$.3f", todayRate) + " " + c.name();
            currency.exchangeRate = value;
            currencyList.add(currency);
        }
        return currencyList;
    }

    private static Double getRate(Rates rates, CurrencyCodesEnum code){
        switch(code){
            case AUD:
                return rates.getAUD();
            case BGN:
                return rates.getBGN();
            case BRL:
                return rates.getBRL();
            case CAD:
                return rates.getCAD();
            case CHF:
                return rates.getCHF();
            case CNY:
                return rates.getCNY();
            case CZK:
                return rates.getCZK();
            case DKK:
                return rates.getDKK();
            case GBP:
                return rates.getGBP();
            case HKD:
                return rates.getHKD();
            case HRK:
                return rates.getHRK();
            case HUF:
                return rates.getHUF();
            case IDR:
                return rates.getIDR();
            case ILS:
                return rates.getILS();
            case INR:
                return rates.getINR();
            case JPY:
                return rates.getJPY();
            case KRW:
                return rates.getKRW();
            case MXN:
                return rates.getMXN();
            case MYR:
                return rates.getMYR();
            case NOK:
                return rates.getNOK();
            case NZD:
                return rates.getNZD();
            case PHP:
                return rates.getPHP();
            case PLN:
                return rates.getPLN();
            case RON:
                return rates.getRON();
            case RUB:
                return rates.getRUB();
            case SEK:
                return rates.getSEK();
            case SGD:
                return rates.getSGD();
            case THB:
                return rates.getTHB();
            case TRY:
                return rates.getTRY();
            case ZAR:
                return rates.getZAR();
            case EUR:
                return rates.getEUR();
            case USD:
                return rates.getUSD();
            default:
                return null;
        }
    }
}

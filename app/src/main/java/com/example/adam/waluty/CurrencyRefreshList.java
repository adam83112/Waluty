package com.example.adam.waluty;

import com.example.adam.waluty.services.ExchangeRatesFromBase;
import com.example.adam.waluty.services.FixerClientTask;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class CurrencyRefreshList {
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


    private static ArrayList<CurrencyModel> getList(ExchangeRatesFromBase erfb){
        ArrayList<CurrencyModel> currencyList = new ArrayList<>();
        for (CurrencyCodesEnum c : CurrencyCodesEnum.values()) {
            Double rate = getRate(erfb.getRates(), c);
            if(rate == null) continue;

            CurrencyModel currency = new CurrencyModel();
            currency.name = c.getDescription();
            currency.image = c.getFlag();
            currency.exchangeRate = rate.toString();
            currencyList.add(currency);
        }
        return currencyList;
    }

    public static void refresh(String base, CurrencyAdapter adapter, ArrayList<CurrencyModel> currencyList) {
        ExchangeRatesFromBase erfb = null;
        try {
            erfb = new FixerClientTask().execute(base).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        currencyList.clear();
        currencyList.addAll(getList(erfb));
        adapter.notifyDataSetChanged();
    }
}

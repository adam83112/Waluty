package com.example.adam.waluty;

import com.example.adam.waluty.services.ExchangeRatesFromBase;
import com.example.adam.waluty.services.FixerClientTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class CurrencyRefreshList {
    public static void refresh(String base, CurrencyAdapter adapter, ArrayList<CurrencyModel> currencyList) {
        Calendar cal = Calendar.getInstance();
        Date lastWorkingDay = DateHelpers.lastWorkingDay(cal.getTime());
        Date previousWorkingDay = DateHelpers.lastWorkingDay(DateHelpers.addDays(lastWorkingDay, -1));
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");


        ExchangeRatesFromBase todayRates = null;
        ExchangeRatesFromBase previousRates = null;
        try {
            todayRates = new FixerClientTask().execute(format1.format(lastWorkingDay), base).get();
            previousRates = new FixerClientTask().execute(format1.format(previousWorkingDay), base).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        currencyList.clear();
        currencyList.addAll(CreateCurrencyModelList.getList(todayRates, previousRates));
        adapter.notifyDataSetChanged();
    }
}

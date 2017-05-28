package com.example.adam.waluty.services;

import android.os.AsyncTask;

import com.example.adam.waluty.CreateCurrencyModelList;
import com.example.adam.waluty.CurrencyAdapter;
import com.example.adam.waluty.CurrencyModel;
import com.example.adam.waluty.DateHelpers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by adam on 13.05.17.
 */

public class FixerClientTask extends AsyncTask<String, Integer, ArrayList<CurrencyModel>> {
    CurrencyAdapter adapter;
    ArrayList<CurrencyModel> currencyList;

    public FixerClientTask(CurrencyAdapter adapter, ArrayList<CurrencyModel> currencyList){
        this.adapter = adapter;
        this.currencyList = currencyList;
    }

    private ExchangeRatesFromBase getPreviousRates(Date date, String base){
        ExchangeRatesFromBase previousRates;
        Date previousDate = date;
        do{
            previousDate = DateHelpers.addDays(previousDate, -1);
            previousRates = FixerWrapper.GetByDateAllExchanges(previousDate, base);
        }while(previousRates.getDate().after(date));
        return previousRates;
    }

    @Override
    protected ArrayList<CurrencyModel>  doInBackground(String... params) {
        ExchangeRatesFromBase todayRates = FixerWrapper.GetLatestAllExchanges(params[0]);
        ExchangeRatesFromBase previousRates = getPreviousRates(todayRates.getDate(), params[0]);

        return CreateCurrencyModelList.getList(todayRates, previousRates);
    }

    @Override
    protected void onPostExecute(ArrayList<CurrencyModel>  result) {
        currencyList.clear();
        currencyList.addAll(result);
        adapter.notifyDataSetChanged();
    }
}
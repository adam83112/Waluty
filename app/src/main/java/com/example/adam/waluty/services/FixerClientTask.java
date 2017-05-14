package com.example.adam.waluty.services;

import android.os.AsyncTask;

import com.example.adam.waluty.CreateCurrencyModelList;
import com.example.adam.waluty.CurrencyAdapter;
import com.example.adam.waluty.CurrencyModel;
import com.example.adam.waluty.DateHelpers;

import java.text.SimpleDateFormat;
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

    @Override
    protected ArrayList<CurrencyModel>  doInBackground(String... params) {
        Calendar cal = Calendar.getInstance();
        Date lastWorkingDay = DateHelpers.lastWorkingDay(cal.getTime());
        Date previousWorkingDay = DateHelpers.lastWorkingDay(DateHelpers.addDays(lastWorkingDay, -1));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        FixerClient fixerClient = new FixerClient();
        String formattedLastWorkingDay = dateFormat.format(lastWorkingDay);
        ExchangeRatesFromBase todayRates = fixerClient.GetByDateAllExchanges(formattedLastWorkingDay, params[0]);
        String formattedPreviousWorkingDay = dateFormat.format(previousWorkingDay);
        ExchangeRatesFromBase previousRates = fixerClient.GetByDateAllExchanges(formattedPreviousWorkingDay, params[0]);

        return CreateCurrencyModelList.getList(todayRates, previousRates);
    }

    @Override
    protected void onPostExecute(ArrayList<CurrencyModel>  result) {
        currencyList.clear();
        currencyList.addAll(result);
        adapter.notifyDataSetChanged();
    }
}
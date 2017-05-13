package com.example.adam.waluty.services;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

/**
 * Created by adam on 13.05.17.
 */

public class FixerClientTask extends AsyncTask<String, Integer, ExchangeRatesFromBase> {
    private Context context;
    public FixerClientTask(Context context){
        this.context = context;
    }

    @Override
    protected ExchangeRatesFromBase doInBackground(String... params) {
        FixerClient fixerClient = new FixerClient();
        ExchangeRatesFromBase exchangeRatesFromBase = fixerClient.GetAllExchanges(params[0]);
        return exchangeRatesFromBase;
    }

    @Override
    protected void onPostExecute(ExchangeRatesFromBase result) {
        Toast.makeText(context, "Obliczono!", Toast.LENGTH_LONG).show();
    }
}
package com.example.adam.waluty.services;

import android.os.AsyncTask;

/**
 * Created by adam on 13.05.17.
 */

public class FixerClientTask extends AsyncTask<String, Integer, ExchangeRatesFromBase> {
    public FixerClientTask(){
    }

    @Override
    protected ExchangeRatesFromBase doInBackground(String... params) {
        FixerClient fixerClient = new FixerClient();
        ExchangeRatesFromBase exchangeRatesFromBase = fixerClient.GetByDateAllExchanges(params[0], params[1]);
        return exchangeRatesFromBase;
    }

//    @Override
//    protected void onPostExecute(ExchangeRatesFromBase result) {
//        //Toast.makeText(context, "Obliczono!", Toast.LENGTH_LONG).show();
//    }
}
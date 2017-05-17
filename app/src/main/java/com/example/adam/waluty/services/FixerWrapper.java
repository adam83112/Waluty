package com.example.adam.waluty.services;

import com.example.adam.waluty.DateHelpers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;

/**
 * Created by adam on 17.05.17.
 */

public class FixerWrapper {
    public static ExchangeRatesFromBase GetByDateAllExchanges(Date date, String base){
        FixerClient fixerClient = new FixerClient();
        String formattedDate = DateHelpers.dateToString(date);
        return fixerClient.GetByDateAllExchanges(formattedDate, base);
    }

    public static ExchangeRatesFromBase GetLatestAllExchanges(String base){
        FixerClient fixerClient = new FixerClient();
        return fixerClient.GetLatestAllExchanges(base);
    }
}

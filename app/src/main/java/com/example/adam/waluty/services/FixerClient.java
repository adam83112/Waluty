package com.example.adam.waluty.services;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adam on 13.05.17.
 */

public class FixerClient {
    private Retrofit retrofit;
    private FixerService service;

    FixerClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.fixer.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        service = retrofit.create(FixerService.class);
    }

    public ExchangeRatesFromBase GetLatestAllExchanges(String base){
        Call<ExchangeRatesFromBase> call = service.getLatestAllExchangesForBase(base);
        try {
            return call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ExchangeRatesFromBase GetByDateAllExchanges(String date, String base){
        Call<ExchangeRatesFromBase> call = service.getByDateAllExchangesForBase(date, base);
        try {
            return call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ExchangeRatesFromBase GetLatestExchange(String base, String second){
        Call<ExchangeRatesFromBase> call = service.getLatestExchangeForBase(base, second);
        try {
            return call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ExchangeRatesFromBase GetByDateExchange(String date, String base, String second){
        Call<ExchangeRatesFromBase> call = service.getByDateExchangeForBase(date, base, second);
        try {
            return call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

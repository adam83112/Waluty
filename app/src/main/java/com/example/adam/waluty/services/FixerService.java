package com.example.adam.waluty.services;


import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by adam on 13.05.17.
 */

public interface FixerService {
    //http://api.fixer.io/latest?base=USD
    @GET("latest")
    Call<ExchangeRatesFromBase> getAllExchangesForBase(@Query("base") String code);
}
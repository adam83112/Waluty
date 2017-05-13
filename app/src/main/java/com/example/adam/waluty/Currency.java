package com.example.adam.waluty;

import android.content.Context;

import com.example.adam.waluty.services.ExchangeRatesFromBase;
import com.example.adam.waluty.services.FixerClientTask;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Currency {
  public String name;
  public int image;
  public String exchangeRate;

  public static ArrayList<Currency> getSampleCurrencies(Context context) {
    new FixerClientTask(context).execute("PLN");

    final ArrayList<Currency> currencyList = new ArrayList<>();

      for(CurrencyCodes c : CurrencyCodes.values()) {
        Currency currency = new Currency();

        currency.name = c.getDescription();
        currency.image = c.getFlag();
        currency.exchangeRate = "dietLabel";

        currencyList.add(currency);
    }

      return currencyList;
  }
}

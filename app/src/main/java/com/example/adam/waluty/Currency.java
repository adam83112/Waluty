package com.example.adam.waluty;

import android.content.Context;
import java.util.ArrayList;

public class Currency {
  public String name;
  public int image;
  public String exchangeRate;

  public static ArrayList<Currency> getSampleCurrencies(Context context) {
    final ArrayList<Currency> currencyList = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
        Currency currency = new Currency();

        currency.name = "title";
        currency.image = R.mipmap.ic_launcher;
        currency.exchangeRate = "dietLabel";

        currencyList.add(currency);
    }

      return currencyList;
  }
}

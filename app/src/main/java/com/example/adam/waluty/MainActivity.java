package com.example.adam.waluty;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  private ListView mListView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final Context context = this;

    // Get data to display
    final ArrayList<Currency> currencyList = Currency.getSampleCurrencies(this);

    // Create adapter
    CurrencyAdapter adapter = new CurrencyAdapter(this, currencyList);

    // Create list view
    mListView = (ListView) findViewById(R.id.currency_list_view);
    mListView.setAdapter(adapter);

    // Set what happens when a list view item is clicked
    mListView.setOnItemClickListener(new OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Currency selectedCurrency = currencyList.get(position);
      }

    });
  }


}

package com.example.adam.waluty;

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

    final ArrayList<CurrencyModel> currencyList = new ArrayList<>();
    CurrencyAdapter adapter = new CurrencyAdapter(this, currencyList);

    mListView = (ListView) findViewById(R.id.currency_list_view);
    mListView.setAdapter(adapter);

    mListView.setOnItemClickListener(new OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CurrencyModel selectedCurrency = currencyList.get(position);
      }

    });


    CurrencyRefreshList.refresh("PLN", adapter, currencyList);
  }


}

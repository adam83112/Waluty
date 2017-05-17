package com.example.adam.waluty;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adam.waluty.services.FixerClientTask;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayList<CurrencyModel> currencyList;
    private CurrencyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currencyList = new ArrayList<>();
        adapter = new CurrencyAdapter(this, currencyList);

        mListView = (ListView) findViewById(R.id.currency_list_view);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CurrencyModel selectedCurrency = currencyList.get(position);
                Context context = view.getContext();
                String countryName = context.getString(selectedCurrency.currencyName);
                Toast.makeText(context, countryName, Toast.LENGTH_SHORT).show();
            }

        });

        loadList("PLN");
    }

    private void loadList(String base){
        new FixerClientTask(adapter, currencyList).execute(base);
    }
}

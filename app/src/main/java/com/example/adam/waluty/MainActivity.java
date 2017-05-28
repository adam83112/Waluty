package com.example.adam.waluty;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.adam.waluty.services.FixerClientTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String FIRST_CURRENCY_MESSAGE = "com.example.adam.waluty.FIRST_CURRENCY";
    public static final String SECOND_CURRENCY_MESSAGE = "com.example.adam.waluty.SECOND_CURRENCY";

    private String baseCurrency;
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
                String countryName = context.getString(selectedCurrency.getCountryName());
                Intent intent = new Intent(view.getContext(), ChartActivity.class);
                intent.putExtra(SECOND_CURRENCY_MESSAGE, countryName);
                intent.putExtra(FIRST_CURRENCY_MESSAGE, baseCurrency);
                startActivity(intent);
            }

        });

        loadList("USD");
    }

    private void loadList(String base)
    {
        setTitle(base);
        baseCurrency = base;
        new FixerClientTask(adapter, currencyList).execute(base);
    }

    public void changeBaseOnClick(View view) {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(MainActivity.this);
        builderSingle.setTitle(R.string.select_base_currency);

        List<CurrencyCodesEnum> currencyList = Arrays.asList(CurrencyCodesEnum.values());
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.select_dialog_item);
        for(CurrencyCodesEnum currency : currencyList){
            arrayAdapter.add(currency.name());
        }

        builderSingle.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strName = arrayAdapter.getItem(which);
                loadList(strName);
            }
        });
        builderSingle.show();
    }
}

package com.example.adam.waluty;

import android.app.AlertDialog;
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


public class MainActivity extends AppCompatActivity {
    public static final String FIRST_CURRENCY_MESSAGE = "com.example.adam.waluty.FIRST_CURRENCY";
    public static final String SECOND_CURRENCY_MESSAGE = "com.example.adam.waluty.SECOND_CURRENCY";

    private CurrencyCodesEnum baseCurrency;
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
                Intent intent = new Intent(view.getContext(), ChartActivity.class);
                intent.putExtra(FIRST_CURRENCY_MESSAGE, baseCurrency);
                intent.putExtra(SECOND_CURRENCY_MESSAGE, selectedCurrency.getCurrencyCodeEnum());
                startActivity(intent);
            }

        });

        loadList(CurrencyCodesEnum.USD);
    }

    private void loadList(CurrencyCodesEnum currency)
    {
        setTitle(currency.name());
        baseCurrency = currency;
        new FixerClientTask(adapter, currencyList).execute(currency.name());
    }

    public void changeBaseOnClick(View view) {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(MainActivity.this);
        builderSingle.setTitle(R.string.select_base_currency);
        final ArrayAdapter<CurrencyCodesEnum> arrayAdapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, CurrencyCodesEnum.values());

        builderSingle.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CurrencyCodesEnum currency = arrayAdapter.getItem(which);
                loadList(currency);
            }
        });
        builderSingle.show();
    }
}

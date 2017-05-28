package com.example.adam.waluty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChartActivity extends AppCompatActivity {

    private TextView firstCurrencyTextView;
    private TextView secondCurrencyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        firstCurrencyTextView = (TextView) findViewById(R.id.first_currency);
        secondCurrencyTextView = (TextView) findViewById(R.id.second_currency);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        CurrencyCodesEnum firstCurrencyCode = (CurrencyCodesEnum) intent.getSerializableExtra(MainActivity.FIRST_CURRENCY_MESSAGE);
        firstCurrencyTextView.setText(firstCurrencyCode.name());
        CurrencyCodesEnum secondCurrencyCode = (CurrencyCodesEnum) intent.getSerializableExtra(MainActivity.SECOND_CURRENCY_MESSAGE);
        secondCurrencyTextView.setText(secondCurrencyCode.name());
    }

}

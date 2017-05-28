package com.example.adam.waluty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        Intent intent = getIntent();

        String firstCurrencyCode = intent.getStringExtra(MainActivity.FIRST_CURRENCY_MESSAGE);
        TextView firstCurrencyTextView = (TextView) findViewById(R.id.first_currency);
        firstCurrencyTextView.setText(firstCurrencyCode);

        String secondCurrencyCode = intent.getStringExtra(MainActivity.SECOND_CURRENCY_MESSAGE);
        TextView secondCurrencyTextView = (TextView) findViewById(R.id.second_currency);
        secondCurrencyTextView.setText(secondCurrencyCode);
    }
}

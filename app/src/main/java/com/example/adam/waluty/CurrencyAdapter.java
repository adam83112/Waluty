package com.example.adam.waluty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CurrencyAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<CurrencyModel> mDataSource;


    public CurrencyAdapter(Context context, ArrayList<CurrencyModel> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return mDataSource.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        // check if the view already exists if so, no need to inflate and findViewById again!
        if (convertView == null) {

            // Inflate the custom row layout from your XML.
            convertView = mInflater.inflate(R.layout.list_item_currency, parent, false);

            // create a new "Holder" with subviews
            holder = new ViewHolder();
            holder.flagImageView = (ImageView) convertView.findViewById(R.id.currency_flag);
            holder.changeImageView = (ImageView) convertView.findViewById(R.id.currency_change);
            holder.currencyNameTextView = (TextView) convertView.findViewById(R.id.currency_name);
            holder.countryNameTextView = (TextView) convertView.findViewById(R.id.country_name);
            holder.exchangeRateTextView = (TextView) convertView.findViewById(R.id.currency_rate);

            // hang onto this holder for future recyclage
            convertView.setTag(holder);
        } else {

            // skip all the expensive inflation/findViewById and just get the holder you already made
            holder = (ViewHolder) convertView.getTag();
        }

        // Get relevant subviews of row view
        TextView countryNameTextView = holder.countryNameTextView;
        TextView currencyNameTextView = holder.currencyNameTextView;
        TextView exchangeRateTextView = holder.exchangeRateTextView;
        ImageView flagImageView = holder.flagImageView;
        ImageView changeImageView = holder.changeImageView;

        //Get corresponding currency for row
        CurrencyModel currency = (CurrencyModel) getItem(position);

        // Update row view's textviews to display currency information
        countryNameTextView.setText(mContext.getString(currency.getCountryName()));
        currencyNameTextView.setText(mContext.getString(currency.getCurrencyName()));
        exchangeRateTextView.setText(currency.getExchangeRate());
        flagImageView.setImageResource(currency.getFlagImage());
        changeImageView.setImageResource(currency.getChangeImage());


        return convertView;
    }

    private static class ViewHolder {
        public TextView currencyNameTextView;
        public TextView countryNameTextView;
        public TextView exchangeRateTextView;
        public ImageView flagImageView;
        public ImageView changeImageView;
    }
}

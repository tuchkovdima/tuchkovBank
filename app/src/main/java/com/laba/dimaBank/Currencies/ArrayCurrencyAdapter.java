package com.laba.dimaBank.Currencies;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laba.dimaBank.MyApp;
import com.laba.dimaBank.R;
import java.text.DecimalFormat;
import java.util.List;

public class ArrayCurrencyAdapter extends BaseAdapter
{
    private Context context;
    private MyApp myApp;
    private List<Flag> flagList;

    public ArrayCurrencyAdapter(Context context)
    {
        this.context = context;
        myApp = (MyApp) context.getApplicationContext();
        flagList = myApp.getFlagList();
    }

    @Override
    public int getCount()
    {
        return myApp.sizeCurrency();
    }

    @Override
    public Object getItem(int position)
    {
        return myApp.getBankPlace(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Context context = parent.getContext();
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_currency_item, parent, false);
        }

        LinearLayout liner = (LinearLayout) convertView;

        ImageView imageViewCurrencyImage = (ImageView) liner.findViewById(R.id.currencyImage);
        TextView textViewCurrencyName = (TextView) liner.findViewById(R.id.currencyName);
        TextView textViewCurrencyDescription = (TextView) liner.findViewById(R.id.currencyDescription);
        TextView textViewCurrencyBuy = (TextView) liner.findViewById(R.id.currencyBuyValue);
        TextView textViewCurrencyBuyArrow = (TextView) liner.findViewById(R.id.currencyBuyArrow);
        TextView textViewCurrencySell = (TextView) liner.findViewById(R.id.currencySellValue);
        TextView textViewCurrencySellArrow = (TextView) liner.findViewById(R.id.currencySellArrow);

        Currency currentCurrency = myApp.getCurrency(position);

        // Установка названия и описания валюты
        String currencyName = currentCurrency.getCurrencyName();
        textViewCurrencyName.setText(currencyName);
        textViewCurrencyDescription.setText(currentCurrency.getDescription());

        // Красивый формат округления double данных на вывод
        DecimalFormat decimalFormat = new DecimalFormat("##.00");
        textViewCurrencyBuy.setText(decimalFormat.format(currentCurrency.getBuy()));
        textViewCurrencySell.setText(decimalFormat.format(currentCurrency.getSell()));

        // Установка флагов
        for (Flag flag : flagList) {
            if (flag.getCurrencyName().equalsIgnoreCase(currencyName)) {
                flag.setImageFromFlag(context, imageViewCurrencyImage);
            }
        }

        // Расположение стрелок валют по принципы Чётный/Нечётный
        if(position % 2 ==0)
        {
            textViewCurrencyBuyArrow.setText("↑");
            textViewCurrencyBuyArrow.setTextColor(Color.GREEN);

            textViewCurrencySellArrow.setText("↓");
            textViewCurrencySellArrow.setTextColor(Color.RED);
        }
        else
        {
            textViewCurrencyBuyArrow.setText("↓");
            textViewCurrencyBuyArrow.setTextColor(Color.RED);

            textViewCurrencySellArrow.setText("↑");
            textViewCurrencySellArrow.setTextColor(Color.GREEN);
        }

        return convertView;
    }
}
package com.loloc.horsefeeder.data;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.loloc.horsefeeder.R;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<RowItem> rowItems;

    public CustomAdapter(Context context, List<RowItem> rowitems) {

        this.context = context;
        this.rowItems = rowitems;
    }


    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.list_item, parent, false);

        }

        RowItem currentItem = (RowItem) getItem(position);

        TextView supplement =   supplement = (TextView) convertView.findViewById(R.id.textView_supplement);
        TextView amount = amount = (TextView) convertView.findViewById(R.id.textView_amount);

        supplement.setText(currentItem.getSupplement());
        amount.setText(currentItem.getAmount().toString());

        return convertView;
    }
    }
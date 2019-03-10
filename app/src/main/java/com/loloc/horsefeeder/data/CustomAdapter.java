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

       Log.i("superduperinfo", String.valueOf(this.rowItems));

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
        return rowItems.indexOf(getItem(position));
    }

    private class ViewHolder {

        TextView supplement;
        TextView amount;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater hInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            convertView = hInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();

            holder.supplement = convertView.findViewById(R.id.textView_supplement);
            holder.amount = convertView.findViewById(R.id.textView_amount);

            RowItem row_pos = rowItems.get(position);

            holder.supplement.setText(row_pos.getSupplement());
            holder.amount.setText(row_pos.getAmount().toString());

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();

        }
        return convertView;
    }
}

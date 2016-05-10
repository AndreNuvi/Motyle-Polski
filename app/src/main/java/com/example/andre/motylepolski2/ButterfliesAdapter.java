package com.example.andre.motylepolski2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Andre on 2016-05-04.
 */
public class ButterfliesAdapter extends ArrayAdapter<Butterfly> {

    private Context context;
    static  List<Butterfly> data;
    static  ArrayList<Butterfly> arrayList;

    public ButterfliesAdapter(Context context, ArrayList<Butterfly> data) {
        super(context, R.layout.layout_list_row);
        this.data = data;
        this.context = context;
        arrayList = new ArrayList<>();
        arrayList.addAll(data);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ButterflyHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(R.layout.layout_list_row, null);
            holder = new ButterflyHolder();
            holder.butterfly = (ImageView) row.findViewById(R.id.imageView);
            holder.name = (TextView) row.findViewById(R.id.name);
            holder.latinName = (TextView) row.findViewById(R.id.latinName);
            row.setTag(holder);
        } else {
            holder = (ButterflyHolder) row.getTag();
        }

        Butterfly butterfly = data.get(position);
        holder.butterfly.setImageResource(butterfly.getImageButterflyId());
        holder.name.setText(butterfly.getName());
        holder.latinName.setText(butterfly.getLatinName());

        return row;
    }

    static class ButterflyHolder {
        ImageView butterfly;
        TextView name;
        TextView latinName;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        data.clear();
        if (charText.length() == 0) {
            data.addAll(arrayList);
        } else {
            for (Butterfly butterflyDetails : arrayList) {
                if (charText.length() != 0 && butterflyDetails.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    data.add(butterflyDetails);
                } else if (charText.length() != 0 && butterflyDetails.getColorTag1().toLowerCase(Locale.getDefault()).contains(charText)) {
                    data.add(butterflyDetails);
                }
            }
        }
        notifyDataSetChanged();

    }
}

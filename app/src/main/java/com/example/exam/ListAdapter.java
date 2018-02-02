package com.example.exam;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ndreca on 1/2/2018.
 */

public class ListAdapter extends ArrayAdapter{
List list = new ArrayList();

    public ListAdapter(@NonNull Context context, int resource) {
        super(context, resource);


    }

    static class LayoutHandler{
        TextView NAME,KG,TIMI,DATE;
    }


    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        list.add(object);
    }


    @Override
    public int getCount() {
        return list.size();
    }


    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);

    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        LayoutHandler layoutHandler;
        if (row==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.NAME=(TextView)row.findViewById(R.id.textN);
            layoutHandler.KG=(TextView)row.findViewById(R.id.textK);
            layoutHandler.TIMI=(TextView)row.findViewById(R.id.textT);
            layoutHandler.DATE=(TextView)row.findViewById(R.id.textD);
            row.setTag(layoutHandler);


        }else{
            layoutHandler=(LayoutHandler)row.getTag();

        }



DataProvider dataProvider=(DataProvider)this.getItem(position);
        layoutHandler.NAME.setText(dataProvider.getName());
        layoutHandler.KG.setText(dataProvider.getKg());
        layoutHandler.TIMI.setText(dataProvider.getTimi());
        layoutHandler.DATE.setText(dataProvider.getDate());
        return row;

    }
}



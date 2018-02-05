package com.example.exam;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {
    DatabaseHelper myHelper;
    SQLiteDatabase db;
    Cursor cursor;
    ListView listView ;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listView = (ListView) findViewById(R.id.list_view);
        myHelper = new DatabaseHelper(getApplicationContext());
        db = myHelper.getReadableDatabase();
        cursor = myHelper.getAllData();
        listAdapter = new ListAdapter(getApplicationContext(), R.layout.row_layout);
        listView.setAdapter(listAdapter);


//προσθηκη στοιχείων στην λιστα με χρηση αντικειμένου
        if (cursor.moveToFirst()) {

            do {
                String name, kg, timi, date;
                name = cursor.getString(0);
                kg = cursor.getString(1);
                timi = cursor.getString(2);
                date = cursor.getString(3);
                DataProvider dataProvider = new DataProvider(name, kg, timi, date);
                listAdapter.add(dataProvider);

            }
            while (cursor.moveToNext());

        }
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listAdapter.rem(position);
                return true;
            }

        });

    }




}

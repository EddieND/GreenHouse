package com.example.exam;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class prosthiki extends AppCompatActivity {
    private Button badd;
    EditText edit_name, edit_timi, edit_date,edit_kg;
     SQLiteDatabase db;
    DatabaseHelper myHelper;
    Context context = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prosthiki);
edit_name = (EditText)findViewById(R.id.n);
edit_timi = (EditText)findViewById(R.id.timi);
edit_kg = (EditText)findViewById(R.id.kg);
edit_date =(EditText)findViewById(R.id.date);

myHelper = new DatabaseHelper(this);
db = myHelper.getWritableDatabase();

    }




    public void insertData(View view) {
        boolean isinserted = myHelper.addInfo(edit_name.getText().toString(),edit_kg.getText().toString(),edit_timi.getText().toString(),edit_date.getText().toString());

      if (isinserted==true){
          Toast.makeText(getApplicationContext(), "προστέθηκε μια νέα καταχώρηση " ,Toast.LENGTH_LONG).show();
      }else
          Toast.makeText(getApplicationContext(), "Κατι πήγε Στραβά " ,Toast.LENGTH_LONG).show();
    }




}

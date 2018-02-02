package com.example.exam;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
DatabaseHelper mDatabaseHelder;
private Button btnadd;



//add button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnadd = (Button) findViewById(R.id.add);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), prosthiki.class);
                startActivity(intent);
            }
        });


//show button το onClick ειναι στο layout
    }
    public void showProsthikes(View view){
        Intent intent = new Intent(getApplicationContext(),Lista.class);
        startActivity(intent);

    }

}

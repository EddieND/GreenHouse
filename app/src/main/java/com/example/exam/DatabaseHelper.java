package com.example.exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


public class DatabaseHelper extends SQLiteOpenHelper{
private static final String DATABASE_NAME = "myDatabase";
private static final String TABLE_NAME = "GreenHouse";
private static final String DB_NAME = "NAME";
    private static final String DB_KG = "KG";
    private static final String DB_TIMI = "TIMI";
    private static final String DB_DATE = "DATE";
    private static final Integer DATABASE_VERSION = 1;


    public DatabaseHelper(Context context){
        super(context,TABLE_NAME ,null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create table " +TABLE_NAME + "(NAME TEXT, KG TEXT, TIMI TEXT, DATE TEXT)");
        Log.e("DATABASE", "Δημιουργήθηκε η Βάση");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addInfo(String name, String kg,String timi, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DB_NAME,name);
        cv.put(DB_KG,kg);
        cv.put(DB_TIMI,timi);
        cv.put(DB_DATE,date);
        db.insert(TABLE_NAME,null,cv);
        return true;
    }

public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result=db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        return result;
}




}




package com.example.exam;

/**
 * Created by ndreca on 1/2/2018.
 */

public class DataProvider {
    private String name;
    private String kg;
    private String timi;
    private String date;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKg() {
        return kg;
    }

    public void setKg(String kg) {
        this.kg = kg;
    }

    public String getTimi() {
        return timi;
    }

    public void setTimi(String timi) {
        this.timi = timi;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DataProvider(String name, String kg, String timi, String date){
        this.name = name;
        this.kg=kg;
        this.timi=timi;
        this.date=date;
    }



}

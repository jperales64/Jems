package com.example.jems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class QuickEstimator extends AppCompatActivity {

    private ListView materialsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_estimator);

        materialsListView = (ListView) findViewById(R.id.materialsListView);

        //Temporary List containing sample items.
        //TODO: create database interfacer to populate lists
        List<String> materialsArrayList = new ArrayList<String>();
        materialsArrayList.add("1\" x 5-1/2\" x 6' Pressure Treated Pine Dog-Ear Fence Picket\t380\t684.00");
        materialsArrayList.add("2\" x 4\" x 8' Pressure Treated Dimensional Lumber\t73\t$240.90");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                materialsArrayList);

        materialsListView.setAdapter(arrayAdapter);
    }
}

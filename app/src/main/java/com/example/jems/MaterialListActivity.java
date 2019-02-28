package com.example.jems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class MaterialListActivity extends AppCompatActivity {
    private RecyclerView materialListRv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_list);
        materialListRv = findViewById(R.id.materialListRV);
    }
}

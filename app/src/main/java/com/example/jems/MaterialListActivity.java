package com.example.jems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.math.BigDecimal;

public class MaterialListActivity extends AppCompatActivity {
    private Material wood = new Material("Wood 2x4", new BigDecimal("12.50"));
    private Material nails = new Material("Nails 6d(50) ", new BigDecimal("2.50"));
    private Material flooring = new Material("Marble 1x1", new BigDecimal("123.50"));
    protected MaterialListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_list);
        RecyclerView materialListRv = findViewById(R.id.materialListRV);
        MaterialList materialList = new MaterialList();
        MaterialListLineItem woodRowItem = new MaterialListLineItem(wood, 50);
        MaterialListLineItem nailRowItem = new MaterialListLineItem(nails, 20);
        MaterialListLineItem floorRowItem = new MaterialListLineItem(flooring, 75);
        materialList.add(woodRowItem);
        materialList.add(nailRowItem);
        materialList.add(floorRowItem);
        adapter = new MaterialListAdapter(materialList);
        materialListRv.setAdapter(adapter);
        materialListRv.setLayoutManager(new LinearLayoutManager(this));
    }
}

package com.example.jems;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends AppCompatActivity {

    ListView listView;
    List list = new ArrayList();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        listView = (ListView)findViewById(R.id.employeeList);
        list.add("Joseph Huebenthal");
        list.add("Richard Lim");

        adapter = new ArrayAdapter(EmployeeActivity.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }

}

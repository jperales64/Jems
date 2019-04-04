package com.example.jems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeesOnProjectActivity extends AppCompatActivity {
    private ArrayList<Employee> employees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees_on_project);
        employees = new ArrayList<>();
        RecyclerView rvEmployees = findViewById(R.id.employeesOnJob);
        rvEmployees.setHasFixedSize(true);
        EmployeesOnJobAdapter adapter = new EmployeesOnJobAdapter(employees);
        rvEmployees.setAdapter(adapter);
        rvEmployees.setLayoutManager(new LinearLayoutManager(this));

    }
}

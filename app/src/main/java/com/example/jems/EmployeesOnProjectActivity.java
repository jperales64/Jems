package com.example.jems;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class EmployeesOnProjectActivity extends AppCompatActivity {
    private List<Employee> employees;
    WorkProjectDatabase wpdb = WorkProjectDatabase.getInstance(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees_on_project);
        employees = wpdb.employeeDao().getAll();
        RecyclerView rvEmployees = findViewById(R.id.employeesOnJob);
        rvEmployees.setHasFixedSize(true);
        EmployeesOnJobAdapter adapter = new EmployeesOnJobAdapter(employees);
        rvEmployees.setAdapter(adapter);
        rvEmployees.setLayoutManager(new LinearLayoutManager(this));

    }
}

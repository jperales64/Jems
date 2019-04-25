package com.example.jems;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class AddEmployeeToJobActivity extends AppCompatActivity {

    private List<Employee> employees;
    WorkProjectDatabase wpdb = WorkProjectDatabase.getInstance(this);
    int projectId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent rIntent = getIntent();
        if (rIntent.hasExtra("projectId")){
            projectId = rIntent.getIntExtra("projectId", -1);
        }
        super.onCreate(savedInstanceState);
        AddEmployeeAdapter.OnItemClickListener listener = new AddEmployeeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int empId) {
                EmployeesOnJob temp = new EmployeesOnJob(getProjectId(),empId);
                wpdb.employeesOnJobDao().insert(temp);
                Intent intent = new Intent(AddEmployeeToJobActivity.this, EmployeesOnProjectActivity.class);
                int projectId = getProjectId();
                intent.putExtra("projectId", projectId);
                startActivity(intent);
            }

        };
        setContentView(R.layout.activity_add_employee_to_job);
        RecyclerView rvEmployees = findViewById(R.id.addEmployeeRecylcleView);

        employees = wpdb.employeeDao().getAll();
        AddEmployeeAdapter adapter = new AddEmployeeAdapter(employees, listener );
        rvEmployees.setAdapter(adapter);
        rvEmployees.setLayoutManager(new LinearLayoutManager(this));


    }

    public int getProjectId() {
        return projectId;
    }


}

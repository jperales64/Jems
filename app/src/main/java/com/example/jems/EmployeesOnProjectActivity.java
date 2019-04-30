package com.example.jems;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class EmployeesOnProjectActivity extends AppCompatActivity {
    private List<EmployeesOnJob> employeesOnJob;
    WorkProjectDatabase wpdb = WorkProjectDatabase.getInstance(this);
    Button addEmployeeButton;
    int projectId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees_on_project);
        Intent intent = getIntent();
        projectId = intent.getIntExtra("projectId",-1);
        if (projectId != -1) {
            employeesOnJob = wpdb.employeesOnJobDao().getAll(projectId);
            System.out.println(projectId);
        }
        RecyclerView rvEmployees = findViewById(R.id.employeesOnJob);
        addEmployeeButton = findViewById(R.id.addEmployeeToProjectButton);
        addEmployeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(EmployeesOnProjectActivity.this, AddEmployeeToJobActivity.class);
                newIntent.putExtra("projectId", projectId);
                startActivityForResult(newIntent,1);

            }
        });
        rvEmployees.setHasFixedSize(true);
        EmployeesOnJobAdapter adapter = new EmployeesOnJobAdapter(employeesOnJob, projectId,this);
        rvEmployees.setAdapter(adapter);
        rvEmployees.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void onBackPressed() {
        NavUtils.navigateUpFromSameTask(this);
    }
}

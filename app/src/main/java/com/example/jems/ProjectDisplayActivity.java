package com.example.jems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProjectDisplayActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_display);
        final Intent i = getIntent();
        final WorkProject project = i.getParcelableExtra("project");
        Customer customer = i.getParcelableExtra("customer");

        TextView custName = findViewById(R.id.workProjectCustNameTextView);
        TextView custAddress = findViewById(R.id.workProjectCustAddress);
        TextView projectCost = findViewById(R.id.projectCostTextView);
        Button toDoListButton = findViewById(R.id.toDoListButton);
        Button employeeListButton = findViewById(R.id.EmployeesOnJobButton);
        Button materialListButton = findViewById(R.id.materialListButton);
        TextView projectMiles = findViewById(R.id.projectMilesEditText);

        String custNameStr = customer.getFirstName() + " " + customer.getLastName();
        custName.setText(custNameStr);
        custAddress.setText(customer.getCustAddress());
        if(project.getActualCost() != null) {
            BigDecimal displayValue = project.getActualCost().setScale(2, RoundingMode.HALF_EVEN);
            String moneyStr = "$" + displayValue.toString();
            projectCost.setText(moneyStr);

        }
        projectMiles.setText(Double.toString(project.getMiles()));

        toDoListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(project.getId());
                int projectId = project.getId();
                Intent intent = new Intent(ProjectDisplayActivity.this, ToDoListActivity.class);
                intent.putExtra("projectId",projectId);
                startActivity(intent);

            }
        });

        employeeListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjectDisplayActivity.this, EmployeesOnProjectActivity.class);
                int projectId = project.getId();
                intent.putExtra("projectId", projectId);
                startActivity(intent);
            }
        });

        materialListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjectDisplayActivity.this, MaterialListActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(ProjectDisplayActivity.this, ProjectTracker.class);
        startActivity(i);
    }
}

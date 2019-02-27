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

    private  WorkProject project;
    private TextView custName;
    private TextView custAddress;
    private TextView projectCost;
    private BigDecimal displayValue;
    private Button toDoListButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_display);
        Intent i = getIntent();
        WorkProject project = i.getParcelableExtra("project");

        custName = findViewById(R.id.workProjectCustNameTextView);
        custAddress = findViewById(R.id.workProjectCustAddress);
        projectCost = findViewById(R.id.projectCostTextView);
        toDoListButton = (Button)findViewById(R.id.toDoListButton);

        custName.setText(project.getCustomerName());
        custAddress.setText(project.getCustomerAddress());
        displayValue = project.getActualCost().setScale(2, RoundingMode.HALF_EVEN);;
        projectCost.setText("$" + displayValue.toString());

        toDoListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjectDisplayActivity.this, ToDoListActivity.class);
                startActivity(intent);

            }
        });

    }
}

package com.example.jems.employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

//import com.example.jems.Employee;
import com.example.jems.R;
import com.example.jems.WorkProjectDatabase;

public class EmployeeTimesheetDetailActivity extends AppCompatActivity {

    private WorkProjectDatabase wpDb;
    private TextView name;
    private TextView wage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_timesheet_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Timesheet Detail");
        setSupportActionBar(toolbar);

        name = findViewById(R.id.detailNameTextView);
        wage = findViewById(R.id.wageTextView);
        wpDb = WorkProjectDatabase.getInstance(this);

        Intent i = getIntent();
        Employee e;
        e = (Employee) i.getParcelableExtra("com.example.jems.EMP_NAME");

        Log.i("EmpTimeSheetDetailAct", "The employee is " + e.getFirstName());

//
        name.setText(e.getFirstName() + " " + e.getLastName());
        wage.setText(Double.toString(e.getWage()));
    }

}

package com.example.jems.employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.example.jems.Employee;
import com.example.jems.R;
import com.example.jems.WorkProjectDatabase;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class EmployeeTimesheetDetailActivity extends AppCompatActivity {

    private WorkProjectDatabase wpDb;
    private TextView name;
    private TextView wage;
    private TextView startDate;
    private Button editEmpBtn;
    private Employee e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_timesheet_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Timesheet Detail");
        setSupportActionBar(toolbar);

        name = findViewById(R.id.detailNameTextView);
        wage = findViewById(R.id.wageTextView);
        startDate = findViewById(R.id.startDateTextView);
        wpDb = WorkProjectDatabase.getInstance(this);

        Intent i = getIntent();
        e = (Employee) i.getParcelableExtra("com.example.jems.EMP_DETAIL_ACT");

        name.setText(e.getFirstName() + " " + e.getLastName());
        wage.setText(Double.toString(e.getWage()));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String sDate = e.getStartDate().format(formatter);
        startDate.setText(sDate);

        // On Edit Employee Button Click
        editEmpBtn = (Button) findViewById(R.id.editEmpBtn);
        editEmpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), EditEmployeeActivity.class);
                i.putExtra("com.example.jems.employee.EDIT_EMP", e);
                startActivity(i);
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), EmployeeActivity.class);
        startActivity(i);
    }
}
